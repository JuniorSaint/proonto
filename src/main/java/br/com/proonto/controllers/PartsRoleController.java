package br.com.proonto.controllers;

import br.com.proonto.models.entities.PartsRole;
import br.com.proonto.services.PartsRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/parts-role")
@Tag(name = "Part's Role", description = "Manager Part's Role")
public class PartsRoleController {
    @Autowired
    private PartsRoleService service;

    @GetMapping("/{id}")
    public ResponseEntity<PartsRole> findById(@PathVariable(value = "id") String  id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(service.findById(id));
    }
}
