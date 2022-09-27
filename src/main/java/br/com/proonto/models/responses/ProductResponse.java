package br.com.proonto.models.responses;

import br.com.proonto.models.entities.LocationProdution;
import br.com.proonto.models.requests.RegistryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ProductResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;
    private LocationProductionResponse LOCALPRODUCAO;
}
