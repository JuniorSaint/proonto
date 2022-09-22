package br.com.proonto.controllers;

import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.requests.ModalitiesOfOperationRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.ModalitiesOfOperationResponseId;
import br.com.proonto.services.ImmovableService;
import br.com.proonto.services.ModalitiesOfOperationsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/modality")
@Tag(name = "Modalidaties of operation", description = "Manager modalidaties of operation")
public class ModalitiesOfOperationController {

    @Autowired
    private ModalitiesOfOperationsService service;

    @PostMapping
    public ResponseEntity<ModalitiesOfOperationResponseId> save(@RequestBody @Valid ModalitiesOfOperationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalitiesOfOperationResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
