package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModalitiesOfOperationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private List<ModalityOfOperationRequest> MODALIDADESOPERACAO;
}
