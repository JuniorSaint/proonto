package br.com.proonto.controllers;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.requests.ContractFirstRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.ContractFirstResponse;
import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.models.responses.ContractResponseId;
import br.com.proonto.services.ContractFirstService;
import br.com.proonto.services.ContractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/contract-general")
@Tag(name = "Contract", description = "Manager contract")
public class ContractGeneralController {
    @Autowired
    private ContractService service;


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseId> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
}
