package br.com.proonto.controllers;

import br.com.proonto.models.requests.CreditorBranchRequest;
import br.com.proonto.models.responses.CreditorBranchResponseId;
import br.com.proonto.services.CreditorBranchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/creditor-branch")
@Tag(name = "Creditor Branch", description = "Manager creditor branch")
public class CreditorsBranchController {
    @Autowired
    private CreditorBranchService service;

    @PostMapping
    public ResponseEntity<CreditorBranchResponseId> save(@RequestBody @Valid CreditorBranchRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreditorBranchResponseId> update(@RequestBody @Valid CreditorBranchRequest request, @PathVariable(value = "id") Long id) {
        request.setId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }
    @GetMapping
    public ResponseEntity<List<CreditorBranchResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("{id_creditor}")
    public ResponseEntity<CreditorBranchResponseId> findById(@PathVariable(value = "id_creditor") Long id_creditor) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id_creditor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}