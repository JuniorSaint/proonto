package br.com.proonto.controllers;

import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.services.BankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/bank")
@Tag(name = "Bank", description = "Manager Bank")
public class BankController {
    @Autowired
    private BankService service;

    @PostMapping
    public ResponseEntity<BankResponseId> save(@RequestBody @Valid BankRequest bankRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(bankRequest));
    }
    @PutMapping
    public ResponseEntity<BankResponseId> update(@RequestBody @Valid BankRequest bankRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(bankRequest));
    }
    @GetMapping
    public ResponseEntity<List<BankResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BankResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}