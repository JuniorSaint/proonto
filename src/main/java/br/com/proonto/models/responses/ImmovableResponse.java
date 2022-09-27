package br.com.proonto.models.responses;

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
    private String TIPOLOCALIZACAO;
    private String TIPOIMOVEL;
    private AddressResponseId ENDERECO;
}
