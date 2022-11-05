package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModalityOfOperationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private ModalityOfTheOperationSubResponse MODALIDADE;
    private ResourcesOriginSubResponse ORIGEMRECURSOS;
    private String DESTINOFINANCIAMENTO;
}
