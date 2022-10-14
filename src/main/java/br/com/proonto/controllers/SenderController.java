package br.com.proonto.controllers;

import br.com.proonto.models.requests.PresenterRequest;
import br.com.proonto.models.requests.SenderRequest;
import br.com.proonto.models.responses.PresenterResponseId;
import br.com.proonto.models.responses.SenderResponseId;
import br.com.proonto.services.PresenterService;
import br.com.proonto.services.SenderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/sender")
@Tag(name = "Sender", description = "Manager sender")
public class SenderController {
    @Autowired
    private SenderService service;

    @PostMapping
    public ResponseEntity<SenderResponseId> save(@RequestBody @Valid SenderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }
    @PutMapping
    public ResponseEntity<SenderResponseId> update(@RequestBody @Valid SenderRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }
    @GetMapping
    public ResponseEntity<List<SenderResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SenderResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}