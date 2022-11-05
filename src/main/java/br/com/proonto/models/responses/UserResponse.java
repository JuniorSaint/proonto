package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.entities.Notification;
import br.com.proonto.models.entities.Permission;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
