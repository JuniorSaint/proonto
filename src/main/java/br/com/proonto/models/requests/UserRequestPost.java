package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRequestPost implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    @NotBlank(message = "Email is a mandatory field.")
    @Email(message = "Email is formatted wrong.")
    private String email;
    @NotBlank(message = "Password is a mandatory field.")
    private String password;
    private String cpf;
    private Boolean active;
    @CreationTimestamp
    private Instant createdAt;
    private List<Permission> permissions;
}
