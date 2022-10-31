package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Financial;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CPRRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String LOCALENTREGA;
    private String PERIODO;
    private String CONDICOES;
    private List<ProductRequest> PRODUTOS;
    private FinancialRequest FINANCEIRO;
    private ContractRequest CONTRATO;
}
