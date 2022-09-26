package br.com.proonto.models.responses;

import br.com.proonto.models.requests.GuaranteeRequest;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.requests.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegistryResponse {
    private String CNS;
    private String LIVRO;
    private String NUMEROREGISTRO;
    private String COMPLEMENTO;
    private ImmovableResponse IMOVEL;
}
