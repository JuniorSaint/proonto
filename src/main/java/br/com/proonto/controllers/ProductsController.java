package br.com.proonto.controllers;

import br.com.proonto.models.requests.ProductRequest;
import br.com.proonto.models.responses.ProductResponseId;
import br.com.proonto.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/product")
@Tag(name = "Product", description = "Manager product")
public class ProductsController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseId> save(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }

}
