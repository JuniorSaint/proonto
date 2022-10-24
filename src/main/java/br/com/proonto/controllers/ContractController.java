//package br.com.proonto.controllers;
//
//import br.com.proonto.models.requests.*;
//import br.com.proonto.models.responses.*;
//import br.com.proonto.services.ContractService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@CrossOrigin(origins = "*", maxAge = 60 * 60)
//@RequestMapping("/v1/contract")
//@Tag(name = "Contract", description = "Manager contract")
//public class ContractsController {
//    @Autowired
//    private ContractService service;
//
//
//
//    @PostMapping("/part")
//    public ResponseEntity<ContractPartsResponse> saveParts(@RequestBody @Valid ContractPartsRequest request) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(service.saveParts(request));
//    }
//
//    @PostMapping("/cpr")
//    public ResponseEntity<ContractCprResponse> saveCpr(@RequestBody @Valid ContractCprRequest request) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(service.saveCpr(request));
//    }
//
//    @PostMapping("/financial")
//    public ResponseEntity<ContractFinancialResponse> saveFinancial(@RequestBody @Valid ContractFinancialRequest request) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(service.saveFinancial(request));
//    }
//
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ContractResponse> findById(@PathVariable(value = "id") Long id) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED)
//                .body(service.findById(id));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id)  {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(service.delete(id));
//    }
//}
