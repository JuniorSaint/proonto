package br.com.proonto.controllers;

import br.com.proonto.models.requests.ChangePasswordRequest;
import br.com.proonto.models.requests.UserRequestPut;
import br.com.proonto.models.responses.UserResponse;
import br.com.proonto.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/users")
@AllArgsConstructor
@Tag(name = "User", description = "Manager users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }



    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequestPut userRequestPut) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUpdate(userRequestPut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody UserRequestPut request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.saveUpdate(request));
    }

    @PutMapping(value = "/change-password", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> changePassowrd(@RequestBody ChangePasswordRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.changePassword(request));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<UserResponse>> findAllUserWithSearch(@RequestParam Optional<String> search, Pageable pageable) {
        try {
            if (search.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(service.findAllWithPage(pageable));
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllWithPageSeek(search.get(), pageable));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllWithPage(pageable));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
