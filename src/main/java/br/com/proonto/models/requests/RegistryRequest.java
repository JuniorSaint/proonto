package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Guarantee;
import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class RegistryRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String CNS;
    private String LIVRO;
    private String NUMEROREGISTRO;
    private String COMPLEMENTO;
    private ImmovableRequest IMOVEL;
}
