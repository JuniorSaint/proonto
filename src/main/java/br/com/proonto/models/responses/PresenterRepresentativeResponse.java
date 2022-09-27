package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class PresenterRepresentativeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private String TIPOPESSOA;
    private String CPFCNPJ;
    private AddressResponseId ENDERECO;
    private ContactResponseId CONTATO;
    private RepresentativeResponseId REPRESENTANTE;
}
