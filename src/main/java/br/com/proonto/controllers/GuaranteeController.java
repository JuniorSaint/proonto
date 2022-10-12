package br.com.proonto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proonto.models.requests.GuaranteeRequest;
import br.com.proonto.models.responses.GuaranteeResponse;
import br.com.proonto.services.GuaranteeService;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/guarantee")
@Tag(name = "Guarantee", description = "Manager guarantee")
public class GuaranteeController {
    @Autowired
    private GuaranteeService service;

    @PostMapping
    public ResponseEntity<GuaranteeResponse> save(@RequestBody @Valid GuaranteeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuaranteeResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
