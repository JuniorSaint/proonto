package br.com.proonto.models.responses;


import br.com.proonto.models.entities.ModalityOfOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModalitiesOfOperationResponse {
    private List<ModalityOfOperationResponse> MODALIDADESOPERACAO;
}
