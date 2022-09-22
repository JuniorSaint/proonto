package br.com.proonto.models.requests;

import br.com.proonto.models.entities.ModalitiesOfOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModalityOfOperationRequest {
    private Long id;
    private String MODALIDADE;
    private String ORIGEMRECURSOS;
    private String DESTINOFINANCIAMENTO;
    private ModalitiesOfOperation MODALIDADESOPERACAO;
}
