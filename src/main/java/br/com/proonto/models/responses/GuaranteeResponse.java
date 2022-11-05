package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"descricao","contrato", "percentualcomprometido", "valor", "qualidade", "quantidade", "marca", "periodoproducao",
"grua", "tipogarantia", "tipobem", "area", "registros"})
public class GuaranteeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private GuaranteeTypeSubResponseId TIPOGARANTIA;
    private PropertyTypeResponseId TIPOBEM;
    private String DESCRICAO;
    private Double PERCENTUALCOMPROMETIDO;
    private Double VALOR;
    private String QUALIDADE;
    private Integer QUANTIDADE;
    private String MARCA;
    private String PERIODOPRODUCAO;
    private String GRAU;
    private AreaResponseId AREA;
    private List<RegistryResponseId> REGISTROS;
    private ContractOnlyIdResponse CONTRATO;
}
