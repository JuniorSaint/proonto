package br.com.proonto.controllers;

import br.com.proonto.models.requests.ModalityOfTheOperationRequest;
import br.com.proonto.models.responses.ModalityOfTheOperationResponse;
import br.com.proonto.services.ModalityOfTheOperationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/madality-of-the-operation")
@Tag(name = "Modality of the operation", description = "Manager Modality of the operation")
public class ModalityOfTheOperationController {
    @Autowired
    private ModalityOfTheOperationService service;

    @PostMapping
    public ResponseEntity<ModalityOfTheOperationResponse> save(@RequestBody @Valid ModalityOfTheOperationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @PutMapping
    public ResponseEntity<ModalityOfTheOperationResponse> update(@RequestBody @Valid ModalityOfTheOperationRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }

    @GetMapping
    public ResponseEntity<List<ModalityOfTheOperationResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalityOfTheOperationResponse> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}