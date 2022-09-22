package br.com.proonto.controllers;

import br.com.proonto.models.requests.PresenterRepresentativeRequest;
import br.com.proonto.models.responses.PresenterRepresentativeResponse;
import br.com.proonto.services.PresenterRepresentativeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/presenter")
@Tag(name = "Presenter and Representative", description = "Maneger presenter and representative")
public class PresenterRepresentativeController {
@Autowired
private PresenterRepresentativeService service;

    @PostMapping
    public ResponseEntity<PresenterRepresentativeResponse> save(@RequestBody @Valid PresenterRepresentativeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenterRepresentativeResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<PresenterRepresentativeResponse> update(@RequestBody @Valid PresenterRepresentativeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }
}
