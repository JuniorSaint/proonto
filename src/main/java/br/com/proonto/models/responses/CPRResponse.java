package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Financial;
import br.com.proonto.models.entities.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CPRResponse {
    private String LOCALENTREGA;
    private String PERIODO;
    private String CONDICOES;
    private List<ProductResponse> PRODUTOS;
    private Financial FINANCEIRO;
}