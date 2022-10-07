package br.com.proonto.models.responses;

import br.com.proonto.models.entities.RegistryOffice;
import br.com.proonto.models.requests.GuaranteeRequest;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.requests.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class RegistryResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private RegistryOffice CNS;
    private String LIVRO;
    private String NUMEROREGISTRO;
    private String COMPLEMENTO;
    private ImmovableResponseId IMOVEL;
}
