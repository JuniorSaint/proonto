package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Guarantee;
import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegistryRequest {

    private Long id;
    private String CNS;
    private String LIVRO;
    private String NUMEROREGISTRO;
    private String COMPLEMENTO;
    private ImmovableRequest IMOVEL;
    private GuaranteeRequest GUARANTEE;
    private ProductRequest PRODUTO;
}
