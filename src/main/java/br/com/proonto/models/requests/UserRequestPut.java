package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Permission;
import lombok.*;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestPut extends UserRequestPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "Id is a mandatory field.")
    private Long id;
    @UpdateTimestamp
    private Instant updatedAt;
}
