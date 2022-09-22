package br.com.proonto.models.responses;

import br.com.proonto.models.requests.CPRRequest;
import br.com.proonto.models.requests.RegistryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ProductResponse implements Serializable {
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;
    private RegistryRequest LOCALPRODUCAO;
}
