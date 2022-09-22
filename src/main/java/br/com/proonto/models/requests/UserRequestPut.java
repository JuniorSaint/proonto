package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Permission;
import lombok.*;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestPut {
    @NotEmpty(message = "Id is a mandatory field.")
    private Long id;
    private String name;
    @NotEmpty(message = "Email is a mandatory field.")
    private String email;
    @NotEmpty(message = "Password is a mandatory field.")
    private String password;
    private String cpf;
    private Boolean active;
    private List<Permission> permissions;
    @UpdateTimestamp
    private Instant updatedAt;
}
