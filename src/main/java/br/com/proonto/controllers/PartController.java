package br.com.proonto.controllers;

import br.com.proonto.models.entities.Part;
import br.com.proonto.services.PartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/part")
@Tag(name = "Part", description = "Manager part")
public class PartController {
    @Autowired
    private PartService service;

    @PostMapping
    public ResponseEntity<Part> save(@RequestBody @Valid Part debtorRequestPost) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(debtorRequestPost));
    }

    @PutMapping
    public ResponseEntity<Part> update(@RequestBody @Valid Part debtorRequestPost) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(debtorRequestPost));
    }

    @GetMapping
    public ResponseEntity<List<Part>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}
