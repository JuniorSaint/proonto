package br.com.proonto.services;

import java.io.*;

import br.com.proonto.exceptions.BadRequestException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import br.com.proonto.configs.CP;
import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Dictionary;
import br.com.proonto.models.entities.Pignoratics;
import br.com.proonto.models.responses.ContractResponseId;
import br.com.proonto.repositories.ContractRepository;
import br.com.proonto.repositories.DictionaryRepository;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class FileHtmlService {
    @Autowired
    private DictionaryRepository repository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    public String convertDataFromFrontToDataToBack(Long id) throws IOException {
        final Pattern PATTERN = Pattern.compile("\\@\\_(.*?)\\_\\@");
        final String TEXT_TO_CHANGE = templateService.findById(id).getBody();
        Matcher matcher = PATTERN.matcher(TEXT_TO_CHANGE);
        String result = TEXT_TO_CHANGE;
        while (matcher.find()) {
            result = result.replaceAll(matcher.group(), valueToChangeExpression(matcher.group()));
        }
        return result;
    }

    public String generateHtmlFromContract(Long id) throws IOException, TemplateException {
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("templateToShow", convertDataFromFrontToDataToBack(id));

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setTemplateLoader(stringLoader);

        Map<String, Object> rootObject = new HashMap<>();
        rootObject.put("tst", createDataToBuildFile(5L));

        Template template = configuration.getTemplate("templateToShow");

        StringWriter stringWriter = new StringWriter();
        template.process(rootObject, stringWriter);

        return stringWriter.toString();
    }

    public void generatePdfFromHtml(Long id) throws IOException, DocumentException, TemplateException {
        try (OutputStream outputStream = new FileOutputStream(CP.PATH_PDF + "Pignoratic - " + Instant.now() + ".pdf")) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(generateHtmlFromContract(id));
            renderer.layout();
            renderer.createPDF(outputStream, false);
            renderer.finishPDF();
        } catch (IOException e) {
            throw new BadRequestException("Problem to generate file - " + e);
        }
    }

    private String valueToChangeExpression(String str) {
        Optional<Dictionary> result = repository.findByFromDic(str);
        if (result.isEmpty()) {
            return "NÃO ENCONTRADO";
        }
        String testBeforeToSend = result.get().getToDic();
        return testBeforeToSend;
    }

    public Pignoratics createDataToBuildFile(Long id) {
        Optional<Contract> resultOp = contractRepository.findById(id);
        if (resultOp.isEmpty()) {
            throw new EntityNotFoundException("Contract" + CP.NOT_FOUND + "id: " + id);
        }
        ContractResponseId result = new ContractResponseId();
        result = mapper.map(resultOp, ContractResponseId.class);

        Pignoratics response = Pignoratics.builder()
                .dueDateUnabbreviated(result.getVENCIMENTOPOREXTENSO())
                .headerTitle(result.getTITULODOCABECALHO())
                .cityStateDateOfContract(result.getCIDADEESTADODATACONTRATO())
                .contractNumber(result.getNUMEROCONTRATO())
                .value(result.getFINANCEIRO().getVALORTOTAL())
                .valueUnabbreviated(result.getFINANCEIRO().getVALOREXTENSO())

                .build();
        return response;
    }
}