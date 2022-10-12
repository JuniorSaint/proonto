package br.com.proonto.services;

import java.io.*;

import br.com.proonto.exceptions.BadRequestException;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
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
import br.com.proonto.models.responses.PartResponseId;
import br.com.proonto.models.responses.QualificationResponseId;
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

    // convert variable from front to variable to back
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

    // Generate entity in the form html
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

    // Generate html into pdf
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
        PartResponseId partCreditor = findCreditor(result.getPARTES(), "3");
        PartResponseId partDebitor = findCreditor(result.getPARTES(), "5");
        PartResponseId partFaithfulDepositary = findCreditor(result.getPARTES(), "17");
        Pignoratics response = Pignoratics.builder()
                .dueDateUnabbreviated(result.getVENCIMENTOPOREXTENSO())
                .headerTitle(result.getTITULODOCABECALHO())
                .cityStateDateOfContract(result.getCIDADEESTADODATACONTRATO())
                .contractNumber(result.getNUMEROCONTRATO())
                .typeOfBanknote(result.getTIPOCEDULA())
                .value(result.getFINANCEIRO().getVALORTOTAL())
                .valueUnabbreviated(result.getFINANCEIRO().getVALOREXTENSO())
                .creditor(partCreditor.getNOME())
                .cnpjCreditor(partCreditor.getCPFCNPJ())
                .streetCreditor(partCreditor.getENDERECO().getLOGRADOURO())
                .numberCreditor(partCreditor.getENDERECO().getNUMERO())
                .districtCreditor(partCreditor.getENDERECO().getBAIRRO())
                .cityCreditor(partCreditor.getENDERECO().getCIDADE())
                .ufCreditor(partCreditor.getENDERECO().getUF())
                .zipCodeCreditor(partCreditor.getENDERECO().getCEP())
                .effectiveInterestPerYear(result.getFINANCEIRO().getTAXAJUROSEFETIVAANUAL())
                .effectiveInterestPerMonth(result.getFINANCEIRO().getTAXAJUROSEFETIVAMENSAL())
                .effectiveInterestPerYearUnabbreviated(result.getFINANCEIRO().getTAXAJUROSEFETIVAANUALPOREXTENSO())
                .effectiveInterestPerMonthUnabbreviated(result.getFINANCEIRO().getTAXAJUROSEFETIVAMENSALPOREXTENSO())
                .fine(result.getFINANCEIRO().getMULTA())
                .fineUnabbreviated(result.getFINANCEIRO().getMULTAPOREXTENSO())
                // .amount()
                // .description()
                // .grade()
                // .harvest()
                // .humidity()
                // .impurities()
                // .damagedAndBurnt()
                // .streetGuarantee()
                // .numberGuarantee()
                // .districtGuarantee()
                // .cityGuarantee()
                // .ufGuarantee()
                // .zipCodeGuarantee()
                // .county()
                // .cns()
                // .ufRegistry()
                .faithfulDepositary(partFaithfulDepositary.getNOME())
                .maritalStatusfaithful(partFaithfulDepositary.getESTADOCIVIL())
                .cpfFaithful(partFaithfulDepositary.getCPFCNPJ())
                .streetFaithful(partFaithfulDepositary.getENDERECO().getLOGRADOURO())
                .numberFaithful(partFaithfulDepositary.getENDERECO().getNUMERO())
                .districtFaithful(partFaithfulDepositary.getENDERECO().getBAIRRO())
                .cityFaithful(partFaithfulDepositary.getENDERECO().getCIDADE())
                .ufFaithful(partFaithfulDepositary.getENDERECO().getUF())
                .zipCodeFaithful(partFaithfulDepositary.getENDERECO().getCEP())
                .debtor(partDebitor.getNOME())
                .maritalStatusDebtor(partDebitor.getESTADOCIVIL())
                .cpfDebtor(partDebitor.getCPFCNPJ())
                .streetDebtor(partDebitor.getENDERECO().getLOGRADOURO())
                .numberDebtor(partDebitor.getENDERECO().getNUMERO())
                .districtDebtor(partDebitor.getENDERECO().getBAIRRO())
                .cityDebtor(partDebitor.getENDERECO().getCIDADE())
                .ufDebtor(partDebitor.getENDERECO().getUF())
                .zipCodeDebtor(partDebitor.getENDERECO().getCEP())
                .birthdayDebtor(partDebitor.getDATANASCIMENTO())
                .documentDebtor(partDebitor.getDOCUMENTO())
                .issuingAgencyDebtor(partDebitor.getORGAOEMISSOR())
                .nacionalityDebtor(partDebitor.getNACIONALIDADE())
                .propertyRegimeDebtor(partDebitor.getREGIMEBENS())
                .profissionDebtor(partDebitor.getPROFISSAO())
                .filiation1Debtor(partDebitor.getFILIACAO1())
                .filiation2Debtor(partDebitor.getFILIACAO2())
                // .cpfSpouseDebtor(partDebitor.)
                .build();
        return response;
    }

    private PartResponseId findCreditor(List<PartResponseId> list, String str) {
        PartResponseId part = new PartResponseId();
        PartResponseId partResult = new PartResponseId();
        QualificationResponseId qualification = new QualificationResponseId();
        for (int x = 0; x < list.size(); x++) {
            partResult = list.get(x);
            for (int i = 0; i < partResult.getQUALIFICACOES().size(); i++) {
                qualification = partResult.getQUALIFICACOES().get(i);
                if (qualification.getQUALIFICACAO().equals(str)) {
                    part = partResult;
                }
            }
        }
        return part;
    }

}