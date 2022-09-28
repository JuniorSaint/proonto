package br.com.proonto.controllers;

import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.ContractsRequest;
import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.models.responses.ContractsResponse;
import br.com.proonto.services.ContractService;
import br.com.proonto.services.ContractsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/contracts")
@Tag(name = "Contracts", description = "Manager contracts")
public class ContractsController {
    @Autowired
    private ContractsService service;

    @PostMapping
    public ResponseEntity<ContractsResponse> save(@RequestBody @Valid ContractsRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractsResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}
