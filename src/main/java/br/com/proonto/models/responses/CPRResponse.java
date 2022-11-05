package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"localentrega", "periodo", "condicoes",  "financeiro","produtos", "contrato"})
public class CPRResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String LOCALENTREGA;
    private String PERIODO;
    private String CONDICOES;
    private List<ProductResponseId> PRODUTOS;
    private FinancialResponseId FINANCEIRO;
    private ContractOnlyIdResponse CONTRATO;
}
