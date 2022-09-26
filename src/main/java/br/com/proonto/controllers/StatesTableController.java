package br.com.proonto.controllers;

import br.com.proonto.models.responses.StatesTableResponse;
import br.com.proonto.services.StatesTableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/states")
@Tag(name = "States", description = "Manager states")
public class StatesTableController {
    @Autowired
    private StatesTableService service;

    @GetMapping
    public ResponseEntity<List<StatesTableResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatesTableResponse> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
