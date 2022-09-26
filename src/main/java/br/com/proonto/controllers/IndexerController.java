package br.com.proonto.controllers;

import br.com.proonto.models.requests.IndexerRequest;
import br.com.proonto.models.responses.IndexerResponse;
import br.com.proonto.services.IndexerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/indexer")
@Tag(name = "Indexer", description = "Manager indexer")
public class IndexerController {
    @Autowired
    private IndexerService service;

    @PostMapping
    public ResponseEntity<IndexerResponse> save(@RequestBody @Valid IndexerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @PutMapping
    public ResponseEntity<IndexerResponse> update(@RequestBody @Valid IndexerRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }

    @GetMapping
    public ResponseEntity<List<IndexerResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndexerResponse> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}