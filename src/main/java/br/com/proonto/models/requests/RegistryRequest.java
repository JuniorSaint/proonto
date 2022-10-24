package br.com.proonto.models.requests;

import br.com.proonto.models.entities.RegistryOffice;
import br.com.proonto.services.RegistryOfficeService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter

public class RegistryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private RegistryOfficeRequest CNS;
    private String LIVRO;
    private String NUMEROREGISTRO;
    private String COMPLEMENTO;
    private ImmovableRequest IMOVEL;

}
