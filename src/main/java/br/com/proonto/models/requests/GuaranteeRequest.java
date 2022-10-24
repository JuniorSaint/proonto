package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Area;
import br.com.proonto.models.entities.GuaranteeTypeSub;
import br.com.proonto.models.entities.PropertyType;
import br.com.proonto.models.entities.Registry;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuaranteeRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private GuaranteeTypeSubRequest TIPOGARANTIA;
    private PropertyTypeRequest TIPOBEM;
    private String DESCRICAO;
    private Double PERCENTUALCOMPROMETIDO;
    private Double VALOR;
    private String QUALIDADE;
    private Integer QUANTIDADE;
    private String MARCA;
    private String PERIODOPRODUCAO;
    private String GRAU;
    private AreaRequest AREA;
    private Set<RegistryRequest> REGISTROS;
    private ContractRequest CONTRATO;
}
