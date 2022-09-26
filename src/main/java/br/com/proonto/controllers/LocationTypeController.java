package br.com.proonto.controllers;

import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.requests.LocationTypeRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.LocationTypeResponse;
import br.com.proonto.services.BankService;
import br.com.proonto.services.LocationTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/location-type")
@Tag(name = "Location Type", description = "Manager location type")
public class LocationTypeController {
    @Autowired
    private LocationTypeService service;

    @PostMapping
    public ResponseEntity<LocationTypeResponse> save(@RequestBody @Valid LocationTypeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @PutMapping
    public ResponseEntity<LocationTypeResponse> update(@RequestBody @Valid LocationTypeRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }

    @GetMapping
    public ResponseEntity<List<LocationTypeResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationTypeResponse> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}