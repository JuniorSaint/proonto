package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Financial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CPRRequest {
    private Long id;
    private String LOCALENTREGA;
    private String PERIODO;
    private String CONDICOES;
    private List<ProductRequest> PRODUTOS;
    private Financial FINANCEIRO;
}
