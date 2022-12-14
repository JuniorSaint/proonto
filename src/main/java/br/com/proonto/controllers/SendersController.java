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
@RequestMapping("/v1/contract")
@Tag(name = "Sender", description = "Manager sender")
public class SendersController {
    @Autowired
    private SenderService service;

    @PostMapping("/{id_contract}/sender")
    public ResponseEntity<SenderResponseId> save(@RequestBody @Valid SenderRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }
    @PutMapping("/{id_contract}/sender/{id_sender}")
    public ResponseEntity<SenderResponseId> update(@RequestBody @Valid SenderRequest request, @PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_sender") Long id_sender) {
      request.setId(id_sender);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
    }
    @GetMapping("all-senders")
    public ResponseEntity<List<SenderResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
    @GetMapping("/{id_contract}/sender/{id_sender}")
    public ResponseEntity<SenderResponseId> findById(@PathVariable(value = "id_sender") Long id_sender, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id_sender));
    }
    @DeleteMapping("/{id_contract}/sender/{id_sender}")
    public ResponseEntity<String> delete(@PathVariable(value = "id_sender") Long id_sender, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id_sender));
    }
}