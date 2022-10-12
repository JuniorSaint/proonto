package br.com.proonto.controllers;

import br.com.proonto.models.entities.Pignoratics;
import br.com.proonto.services.ContractService;
import br.com.proonto.services.FileHtmlService;
import com.lowagie.text.DocumentException;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/html")
public class FileHtmlController {
    @Autowired
    private ContractService service;
    @Autowired
    private FileHtmlService fileHtmlService;


    @GetMapping("/{id}")
    public ResponseEntity<String> contractInHtml(@PathVariable(value = "id") Long id) throws IOException, TemplateException {
        return ResponseEntity.status(HttpStatus.OK)
                    .body(fileHtmlService.generateHtmlFromContract(id));
    }

    @GetMapping("/test/{id}")
    public void contractReturnText(@PathVariable(value = "id") Long id) throws TemplateException, DocumentException, IOException {
        fileHtmlService.generatePdfFromHtml(id);
    }
}
