package br.com.proonto.controllers;

import br.com.proonto.models.requests.PresenterRequest;
import br.com.proonto.models.requests.SenderRequest;
import br.com.proonto.models.responses.SenderResponseId;
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
@RequestMapping("/v1/senders")
@Tag(name = "Sender", description = "Manager sender")
public class SendersController {
    @Autowired
    private SenderService service;

    @PostMapping("/{id_contract}")
    public ResponseEntity<SenderResponseId> save(@RequestBody @Valid SenderRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }
    @PutMapping("/{id_contract}")
    public ResponseEntity<SenderResponseId> update(@RequestBody @Valid SenderRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
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