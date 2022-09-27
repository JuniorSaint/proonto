package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Area;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Registry;
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
public class GuaranteeRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
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
    private AreaRequest AREA;
    private List<RegistryRequest> REGISTROS;
}
