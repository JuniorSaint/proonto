package br.com.proonto.controllers;

import java.util.List;

import javax.validation.Valid;

import br.com.proonto.models.entities.AgencyBank;
import br.com.proonto.models.responses.AgencyBankResponseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proonto.models.requests.AgencyBankRequest;
import br.com.proonto.models.responses.AgencyBankResponseId;
import br.com.proonto.services.AgencyBankService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/agency-bank")
@Tag(name = "Agency Bank", description = "Manager Agency Bank")
public class AgencyBanksController {
    @Autowired
    private AgencyBankService service;

    @PostMapping
    public ResponseEntity<AgencyBankResponseId> save(@RequestBody @Valid AgencyBankRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgencyBankResponseId> update(@RequestBody @Valid AgencyBankRequest request, @PathVariable(value = "id") Long id) {
        request.setId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }

    @GetMapping
    public ResponseEntity<List<AgencyBankResponseId>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgencyBankResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @GetMapping("/count/{count}")
    public ResponseEntity<AgencyBankResponseTest> findByIdT(@PathVariable(value = "count") String count) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findByAgencyBank(count));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws Exception {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.delete(id));
    }
}
