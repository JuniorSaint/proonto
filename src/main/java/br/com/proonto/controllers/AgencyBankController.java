package br.com.proonto.controllers;

import br.com.proonto.models.entities.AgencyBank;
import br.com.proonto.models.requests.AgencyBankRequest;
import br.com.proonto.models.responses.AgencyBankResponseId;
import br.com.proonto.services.AgencyBankService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/agency-bank")
@Tag(name = "Agency Bank", description = "Manager Agency Bank")
public class AgencyBankController {
    @Autowired
    private AgencyBankService service;

    @PostMapping
    public ResponseEntity<AgencyBankResponseId> save(@RequestBody @Valid AgencyBankRequest agencyBank) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(agencyBank));
    }

    @PutMapping
    public ResponseEntity<AgencyBankResponseId> update(@RequestBody @Valid AgencyBankRequest agencyBank) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(agencyBank));
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws Exception {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.delete(id));
    }
}