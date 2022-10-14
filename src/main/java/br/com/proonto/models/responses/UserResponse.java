package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.entities.Notification;
import br.com.proonto.models.entities.Permission;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    private String cpf;
    private Boolean active;
    private Instant createdAt;
    private List<Permission> permissions;
    private List<Notification> notifications;
    private Creditor creditor;
}
