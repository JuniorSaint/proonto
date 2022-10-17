package br.com.proonto.models.responses;

import br.com.proonto.models.entities.PartsRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class QualificationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private PartsRole QUALIFICACAO;
}
