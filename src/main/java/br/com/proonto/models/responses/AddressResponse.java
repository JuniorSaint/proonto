package br.com.proonto.models.responses;

import br.com.proonto.models.requests.AddressTypeRequest;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private AddressTypeReponse TIPOLOGRADOURO;
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
