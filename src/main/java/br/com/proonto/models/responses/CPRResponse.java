package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Financial;
import br.com.proonto.models.entities.Product;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CPRResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String LOCALENTREGA;
    private String PERIODO;
    private String CONDICOES;
    private List<ProductResponseId> PRODUTOS;
    private FinancialResponseId FINANCEIRO;
    private ContractOnlyIdResponse CONTRATO;
}
