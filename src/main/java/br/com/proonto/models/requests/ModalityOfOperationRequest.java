package br.com.proonto.models.requests;

import br.com.proonto.models.entities.ModalityOfTheOperationSub;
import br.com.proonto.models.entities.ResourcesOriginSub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ModalityOfOperationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private ModalityOfTheOperationSubRequest MODALIDADE;
    private ResourcesOriginSubRequest ORIGEMRECURSOS;
    private String DESTINOFINANCIAMENTO;
}
