package br.com.proonto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proonto.models.requests.FinancialRequest;
import br.com.proonto.models.responses.FinancialResponseId;
import br.com.proonto.services.FinancialService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/contract")
@Tag(name = "Financial", description = "Manager financial")
public class FinancialsController {
    @Autowired
    private FinancialService service;

    @PostMapping("/{id_contract}/financial")
    public ResponseEntity<FinancialResponseId> save(@RequestBody @Valid FinancialRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }

    @PutMapping("/{id_contract}/financial/{id_financial}")
    public ResponseEntity<FinancialResponseId> update(@RequestBody @Valid FinancialRequest request, @PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_financial") Long id_financial) {
        request.setId(id_financial);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }

    @GetMapping("/{id}/financial/{id_financial}")
    public ResponseEntity<FinancialResponseId> findById(@PathVariable(value = "id") Long id, @PathVariable(value = "id_financial") Long id_financial) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id_financial));
    }
}