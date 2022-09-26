package br.com.proonto.controllers;

import br.com.proonto.models.requests.GuaranteeRequest;
import br.com.proonto.models.requests.ProductRequest;
import br.com.proonto.models.responses.GuaranteeResponse;
import br.com.proonto.models.responses.ProductResponseId;
import br.com.proonto.services.GuaranteeService;
import br.com.proonto.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



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
