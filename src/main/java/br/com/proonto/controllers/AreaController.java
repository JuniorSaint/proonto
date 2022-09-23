package br.com.proonto.controllers;

import br.com.proonto.models.requests.AreaRequest;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.responses.AreaResponse;
import br.com.proonto.models.responses.AreaResponseId;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.services.AreaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/area")
@Tag(name = "Area", description = "Manager area")
public class AreaController {

    @Autowired
    private AreaService service;

    @PostMapping
    public ResponseEntity<AreaResponse> save(@RequestBody @Valid AreaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }
    @PutMapping
    public ResponseEntity<AreaResponse> update(@RequestBody @Valid AreaRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
