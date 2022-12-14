package br.com.proonto.controllers;

import br.com.proonto.models.requests.PresenterRequest;
import br.com.proonto.models.responses.PresenterResponseId;
import br.com.proonto.services.PresenterService;
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
public class PresentersController {
    @Autowired
    private PresenterService service;

    @PostMapping("/{id_contract}/presenter")
    public ResponseEntity<PresenterResponseId> save(@RequestBody @Valid PresenterRequest request, @PathVariable(value = "id_contract") Long id_contract) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request, id_contract));
    }

    @PutMapping("/{id_contract}/presenter/{id_presenter}")
    public ResponseEntity<PresenterResponseId> update(@RequestBody @Valid PresenterRequest request, @PathVariable(value = "id_contract") Long id_contract, @PathVariable(value = "id_presenter") Long id_presenter) {
        request.setId(id_presenter);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request, id_contract));
    }

    @GetMapping("all-presenters")
    public ResponseEntity<List<PresenterResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @GetMapping("/{id_contract}/presenter/{id_presenter}")
    public ResponseEntity<PresenterResponseId> findById(@PathVariable(value = "id_presenter") Long id_presenter, @PathVariable(value = "id_presenter") Long id_contract) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id_presenter));
    }

    @DeleteMapping("/{id_contract}/presenter/{id_presenter}")
    public ResponseEntity<String> delete(@PathVariable(value = "id_presenter") Long id_presenter, @PathVariable(value = "id_presenter") Long id_contract) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id_presenter));
    }
}