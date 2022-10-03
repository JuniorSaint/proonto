package br.com.proonto.controllers;

import br.com.proonto.models.entities.GuaranteeType;
import br.com.proonto.models.requests.GuaranteeTypeRequest;
import br.com.proonto.models.requests.UploadFileRequest;
import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.services.ContractService;
import br.com.proonto.services.FileHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/html")
public class FileHtmlController {
    @Autowired
    private ContractService service;
    @Autowired
    private FileHtmlService fileHtmlService;

    @GetMapping("/{id}")
    public String contractHtml(Model model, @PathVariable(value = "id") Long id) {
        ContractResponse contract = service.findById(id);
        model.addAttribute("tst", contract);
        return "PignoraticRuralBill";
    }

    @PostMapping("/text")
    public ResponseEntity<List<String>> uploadFile(@ModelAttribute UploadFileRequest files) throws IOException, InterruptedException {
        return ResponseEntity.status(HttpStatus.OK).body(fileHtmlService.recordDataToDb());
    }
}
