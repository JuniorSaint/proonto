package br.com.proonto.models.responses;

import br.com.proonto.models.requests.RegistryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;
    private RegistryRequest LOCALPRODUCAO;
}
