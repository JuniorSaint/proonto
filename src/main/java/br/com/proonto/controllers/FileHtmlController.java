package br.com.proonto.controllers;

import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/html")
public class FileHtmlController {
    @Autowired
    private ContractService service;

    @GetMapping("/{id}")
    public String contractHtml(Model model, @PathVariable(value = "id") Long id) {
        ContractResponse contract = service.findById(id);
        model.addAttribute("TIPOCEDULA", contract.getTIPOCEDULA());
        model.addAttribute("VALORTOTAL", contract.getFINANCEIRO().getVALORTOTAL());
        model.addAttribute("VALOREXTENSO", contract.getFINANCEIRO().getVALOREXTENSO());
        model.addAttribute("tst", contract);
        return "PignoraticRuralBill";
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ContractResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
