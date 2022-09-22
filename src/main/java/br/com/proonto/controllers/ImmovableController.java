package br.com.proonto.controllers;

import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.services.ImmovableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/immovable")
@Tag(name = "Immovable", description = "Manager immovable")
public class ImmovableController {
    @Autowired
    private ImmovableService service;

    @PostMapping
    public ResponseEntity<Immovable> save(@RequestBody @Valid ImmovableRequest immovableRequestPost) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(immovableRequestPost));
    }
    @PutMapping
    public ResponseEntity<Immovable> update(@RequestBody @Valid ImmovableRequest immovableRequestPost) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(immovableRequestPost));
    }
    @GetMapping
    public ResponseEntity<List<Immovable>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Immovable> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}