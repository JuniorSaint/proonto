package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;

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
