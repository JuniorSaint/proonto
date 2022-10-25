package br.com.proonto.controllers;

import br.com.proonto.models.requests.CreditorMatrixRequest;
import br.com.proonto.models.responses.CreditorMatrixResponseId;
import br.com.proonto.services.CreditorMatrixService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/creditor-matrix")
@Tag(name = "Creditor", description = "Manager creditor")
public class CreditorsMatrixController {
    @Autowired
    private CreditorMatrixService service;

    @PostMapping("/{id_contract}")
    public ResponseEntity<CreditorMatrixResponseId> save(@RequestBody @Valid CreditorMatrixRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }
    @PutMapping("/{id_contract}/id-creditor/{id_creditor}")
    public ResponseEntity<CreditorMatrixResponseId> update(@RequestBody @Valid CreditorMatrixRequest request, @PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_creditor") Long id_creditor) {
        request.setId(id_creditor);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
    }
    @GetMapping
    public ResponseEntity<List<CreditorMatrixResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreditorMatrixResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}