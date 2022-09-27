package br.com.proonto.models.responses;

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
    private String MODALIDADE;
    private String ORIGEMRECURSOS;
    private String DESTINOFINANCIAMENTO;
}
