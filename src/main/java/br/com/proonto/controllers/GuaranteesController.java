package br.com.proonto.controllers;

import javax.validation.Valid;

import br.com.proonto.models.requests.GuaranteeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.proonto.models.responses.GuaranteeResponse;
import br.com.proonto.services.GuaranteeService;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/contract")
@Tag(name = "Guarantee", description = "Manager guarantee")
public class GuaranteesController {
    @Autowired
    private GuaranteeService service;

    @PostMapping("/{id_contract}/guarantee")
    public ResponseEntity<GuaranteeResponse> save(@PathVariable(value = "id_contract") Long id_contract, @RequestBody @Valid GuaranteeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }

    @PutMapping("/{id_contract}/guarantee/{id_guarantee}")
    public ResponseEntity<GuaranteeResponse> update(@PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_guarantee") Long id_guarantee, @RequestBody @Valid GuaranteeRequest request) {
        request.setId(id_guarantee);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
    }

    @GetMapping("/{id}/guarantee/{id_guarantee}")
    public ResponseEntity<GuaranteeResponse> findById(@PathVariable(value = "id_guarantee") Long id_guarantee, @PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id_guarantee));
    }

    @DeleteMapping("guarantee/{id_guarantee}")
    public ResponseEntity<String> delete(@PathVariable(value = "id_contract") Long id_guarantee) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id_guarantee));
    }
}
