package br.com.proonto.controllers;

import br.com.proonto.models.requests.*;
import br.com.proonto.models.responses.*;
import br.com.proonto.services.ContractFirstService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/contract")
@Tag(name = "Contract", description = "Manager contract")
public class ContractFirstsController {
    @Autowired
    private ContractFirstService service;

    @PostMapping
    public ResponseEntity<ContractFirstResponse> saveFirst(@RequestBody @Valid ContractFirstRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdade(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractFirstResponse> updateFirst(@RequestBody @Valid ContractFirstRequest request, @PathVariable(value = "id") Long id) {
        request.setId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdade(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractFirstResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}
