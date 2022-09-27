package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ModalityOfOperationResponseId extends ModalityOfOperationResponse {
    private static final long serialVersionUID = 1L;
    private Long id;
}
