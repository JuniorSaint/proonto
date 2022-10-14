package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.LocationType;
import br.com.proonto.models.entities.PropertyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ImmovableResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String EDIFICACAO;
    private String DESCRICAO;
    private LocationType TIPOLOCALIZACAO;
    private PropertyType TIPOIMOVEL;
    private Address ENDERECO;
}
