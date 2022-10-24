package br.com.proonto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proonto.models.requests.TemplateRequest;
import br.com.proonto.models.responses.TemplateResponse;
import br.com.proonto.services.TemplateService;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/template")
@Tag(name = "Template", description = "Manager template")
public class TemplatesController {
    @Autowired
    private TemplateService service;

    @PostMapping
    public ResponseEntity<TemplateResponse> save(@RequestBody @Valid TemplateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }
    @PutMapping
    public ResponseEntity<TemplateResponse> update(@RequestBody @Valid TemplateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }
    @GetMapping
    public ResponseEntity<List<TemplateResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TemplateResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}