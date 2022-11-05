package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","nome", "cpfcnpj", "contrato", "tipopessoa", "endereco", "contato", "representante"})
public class PresenterResponseId extends PresenterResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
