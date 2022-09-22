package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModalitiesOfOperationRequest {
    private Long id;
    private List<ModalityOfOperationRequest> MODALIDADESOPERACAO;
}
