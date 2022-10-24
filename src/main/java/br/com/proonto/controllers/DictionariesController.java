package br.com.proonto.controllers;

import br.com.proonto.models.requests.DictionaryRequest;
import br.com.proonto.models.responses.DictionaryResponseId;
import br.com.proonto.services.DictionaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/dictionary")
@Tag(name = "Dictionary", description = "Manager dictionary")
public class DictionariesController {
    @Autowired
    private DictionaryService service;

    @PostMapping
    public ResponseEntity<DictionaryResponseId> save(@RequestBody @Valid DictionaryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }
    @PutMapping
    public ResponseEntity<DictionaryResponseId> update(@RequestBody @Valid DictionaryRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }
    @GetMapping
    public ResponseEntity<List<DictionaryResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DictionaryResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}