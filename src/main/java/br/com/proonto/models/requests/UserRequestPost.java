package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@SuperBuilder
public class UserRequestPost {
    private String name;
    @NotEmpty(message = "Email is a mandatory field.")
    private String email;
    @NotEmpty(message = "Password is a mandatory field.")
    private String password;
    private String cpf;
    private Boolean active;
    @CreationTimestamp
    private Instant createdAt;
    private List<Permission> permissions;
}