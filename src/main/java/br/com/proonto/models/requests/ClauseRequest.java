package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClauseRequest {
    private Long id;
    private String CLAUSULA;
    private ContractRequest CONTRATO;
}
