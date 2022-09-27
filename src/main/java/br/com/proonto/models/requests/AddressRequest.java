package br.com.proonto.models.requests;

import br.com.proonto.models.entities.PresenterRepresentative;
import lombok.*;

import javax.persistence.OneToOne;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String TIPOLOGRADOURO;
    private String LOGRADOURO;
    private String NUMERO;
    private String BAIRRO;
    private String CIDADE;
    private String UF;
    private String LOTE;
    private String QUADRA;
    private String TORRE;
    private String COMPLEMENTO;
    private String CEP;
}
