package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PresenterRepresentativeResponse {
    private String NOME;
    private String TIPOPESSOA;
    private String CPFCNPJ;
    private AddressResponseId ENDERECO;
    private ContactResponseId CONTATO;
    private RepresentativeResponseId REPRESENTANTE;
}
