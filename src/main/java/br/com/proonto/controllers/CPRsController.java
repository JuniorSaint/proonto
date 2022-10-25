package br.com.proonto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.proonto.models.requests.CPRRequest;
import br.com.proonto.models.responses.CPRResponse;
import br.com.proonto.services.CPRService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/cprs")
@Tag(name = "CPR", description = "Manager cpr")
public class CPRsController {
    @Autowired
    private CPRService service;

    @PostMapping("/{id_contract}")
    public ResponseEntity<CPRResponse> save(@RequestBody @Valid CPRRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }
    @PutMapping("/{id_contract}/id-cpr/{id_cpr}")
    public ResponseEntity<CPRResponse> update(@RequestBody @Valid CPRRequest request, @PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_cpr") Long id_cpr) {
        request.setId(id_cpr);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CPRResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
