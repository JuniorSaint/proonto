package br.com.proonto.controllers;

import br.com.proonto.models.entities.GuaranteeTypeSub;
import br.com.proonto.models.requests.GuaranteeTypeSubRequest;
import br.com.proonto.services.GuaranteeTypeSubService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/guarantee-type-sub")
@Tag(name = "Guarantee Type Sub", description = "Manager guarantee type sub")
public class GuaranteeTypeSubsController {
    @Autowired
    private GuaranteeTypeSubService service;
    @PostMapping
    public ResponseEntity<GuaranteeTypeSub> save(@RequestBody @Valid GuaranteeTypeSubRequest guaranteeTypeSubRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(guaranteeTypeSubRequest));
    }
    @PutMapping
    public ResponseEntity<GuaranteeTypeSub> update(@RequestBody @Valid GuaranteeTypeSubRequest guaranteeTypeSubRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(guaranteeTypeSubRequest));
    }
    @GetMapping
    public ResponseEntity<List<GuaranteeTypeSub>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GuaranteeTypeSub> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));

    }
}
