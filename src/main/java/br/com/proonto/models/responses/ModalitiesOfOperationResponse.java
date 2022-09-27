package br.com.proonto.models.responses;


import br.com.proonto.models.entities.ModalityOfOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModalitiesOfOperationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ModalityOfOperationResponse> MODALIDADESOPERACAO;
}
