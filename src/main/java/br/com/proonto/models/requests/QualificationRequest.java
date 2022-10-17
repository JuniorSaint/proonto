package br.com.proonto.models.requests;

import br.com.proonto.models.entities.PartsRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class QualificationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private PartsRole QUALIFICACAO;
}
