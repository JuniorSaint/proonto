package br.com.proonto.controllers;

import br.com.proonto.models.requests.PartRequest;
import br.com.proonto.models.responses.PartResponseId;
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
@RequestMapping("/v1/contract")
@Tag(name = "Part", description = "Manager part unity")
public class PartsController {
    @Autowired
    private PartService service;

    @PostMapping("/{id_contract}/part")
    public ResponseEntity<PartResponseId> save(@RequestBody @Valid PartRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }

    @PutMapping("/{id_contract}/part/{id_part}")
    public ResponseEntity<PartResponseId> update(@RequestBody @Valid PartRequest request, @PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_part") Long id_part) {
       request.setId(id_part);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
    }

    @GetMapping
    public ResponseEntity<List<PartResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findAll());
    }

    @GetMapping("/{id_contract}/part/{id_part}")
    public ResponseEntity<PartResponseId> findById(@PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_part") Long id_part) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id_part));
    }
}