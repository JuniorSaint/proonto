package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Financial;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id","localentrega", "periodo", "condicoes", "contrato", "financeiro","produtos"})
public class CPRResponseId extends CPRResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
