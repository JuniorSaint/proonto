package br.com.proonto.models.requests;

import br.com.proonto.models.entities.CPR;
import br.com.proonto.models.entities.Registry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class ProductRequest implements Serializable {
    private Long id;
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;
    private RegistryRequest LOCALPRODUCAO;
}
