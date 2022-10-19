package br.com.proonto.models.responses;

import br.com.proonto.models.entities.ModalityOfTheOperationSub;
import br.com.proonto.models.entities.ResourcesOriginSub;
import br.com.proonto.models.requests.ContractRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ModalityOfOperationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private ModalityOfTheOperationSubResponse MODALIDADE;
    private ResourcesOriginSubResponse ORIGEMRECURSOS;
    private String DESTINOFINANCIAMENTO;
}
