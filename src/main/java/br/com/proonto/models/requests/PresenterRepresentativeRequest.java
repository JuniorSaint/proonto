package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PresenterRepresentativeRequest {
    private Long id;
    private String NOME;
    private String TIPOPESSOA;
    private String CPFCNPJ;
    private AddressRequest ENDERECO;
    private ContactRequest CONTATO;
    private RepresentativeRequest REPRESENTANTE;
}
