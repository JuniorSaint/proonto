package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"id","nome", "cpfcnpj", "contrato", "tipopessoa", "endereco", "contato", "representante"})
public class PresenterResponseId extends PresenterResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
