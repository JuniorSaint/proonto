package br.com.proonto.controllers;

import br.com.proonto.models.entities.PropertyType;
import br.com.proonto.models.requests.PropertyTypeRequest;
import br.com.proonto.services.PropertyTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/property-type")
@Tag(name = "Property Type", description = "Manager property type")
public class PropertyTypeController {
    @Autowired
    private PropertyTypeService service;

    @PostMapping
    public ResponseEntity<PropertyType> save(@RequestBody @Valid PropertyTypeRequest propertyTypeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(propertyTypeRequest));
    }

    @PutMapping
    public ResponseEntity<PropertyType> update(@RequestBody @Valid PropertyTypeRequest propertyTypeRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(propertyTypeRequest));
    }

    @GetMapping
    public ResponseEntity<List<PropertyType>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyType> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}
