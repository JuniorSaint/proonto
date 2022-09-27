package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Area;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Registry;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GuaranteeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String TIPOGARANTIA;
    private String TIPOBEM;
    private String DESCRICAO;
    private Double PERCENTUALCOMPROMETIDO;
    private Double VALOR;
    private String QUALIDADE;
    private Integer QUANTIDADE;
    private String MARCA;
    private String PERIODOPRODUCAO;
    private String GRAU;
    private AreaResponse AREA;
    private List<RegistryResponseId> REGISTROS;
}
