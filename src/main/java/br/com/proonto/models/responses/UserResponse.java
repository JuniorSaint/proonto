package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Permission;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;
    private Boolean active;
    private String cpf;
    private Instant createdAt;
    private Instant updatedAt;
    private List<Permission> permissions;
}
