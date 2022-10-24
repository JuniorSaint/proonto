package br.com.proonto.controllers;

import br.com.proonto.models.entities.GuaranteeType;
import br.com.proonto.models.requests.GuaranteeTypeRequest;
import br.com.proonto.services.GuaranteeTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/guarantee-type")
@Tag(name = "Guarantee Type", description = "Manager guarantee type")
public class GuaranteeTypesController {
    @Autowired
    private GuaranteeTypeService service;
    @PostMapping
    public ResponseEntity<GuaranteeType> save(@RequestBody @Valid GuaranteeTypeRequest guaranteeTypeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(guaranteeTypeRequest));
    }
    @PutMapping
    public ResponseEntity<GuaranteeType> update(@RequestBody @Valid GuaranteeTypeRequest guaranteeTypeRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(guaranteeTypeRequest));
    }
    @GetMapping
    public ResponseEntity<List<GuaranteeType>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GuaranteeType> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}
