package br.com.proonto.controllers;

import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.requests.FinancialRequest;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.responses.FinancialResponse;
import br.com.proonto.models.responses.FinancialResponseId;
import br.com.proonto.services.FinancialService;
import br.com.proonto.services.ImmovableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/financial")
@Tag(name = "Financial", description = "Manager financial")
public class FinancialController {
    @Autowired
    private FinancialService service;

    @PostMapping
    public ResponseEntity<FinancialResponseId> save(@RequestBody @Valid FinancialRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @PutMapping
    public ResponseEntity<FinancialResponseId> update(@RequestBody @Valid FinancialRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}