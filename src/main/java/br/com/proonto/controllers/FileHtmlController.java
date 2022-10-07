package br.com.proonto.controllers;

import br.com.proonto.models.entities.Pignoratics;
import br.com.proonto.services.ContractService;
import br.com.proonto.services.FileHtmlService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;

@Controller
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/html")
public class FileHtmlController {
    @Autowired
    private ContractService service;
    @Autowired
    private FileHtmlService fileHtmlService;

    @GetMapping("/{id}")
    public String contractHtml(Model model, @PathVariable(value = "id") Long id) throws IOException, TemplateException {
        String test = fileHtmlService.recordDataToDb(id);
        Pignoratics pignoratics = fileHtmlService.createDataToBuildFile(5L);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("OKTemp", test);

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setTemplateLoader(stringLoader);

        Map<String, Object> rootObject = new HashMap<>();

        rootObject.put("tst", pignoratics);

        Template template = configuration.getTemplate("OKTemp");

        StringWriter stringWriter = new StringWriter();
        template.process(rootObject, stringWriter);
        System.out.println(stringWriter.toString());
        return stringWriter.toString();
    }
    @GetMapping("/test/{id}")
    public Pignoratics contractReturnText(@PathVariable(value = "id") Long id) {
        Pignoratics result =  fileHtmlService.createDataToBuildFile(id);
        return result;
    }


}
