package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"nome", "cpfcnpj", "contrato", "tipopessoa", "endereco", "contato", "representante"})
public class PresenterResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private PersonTypeResponse TIPOPESSOA;
    private String CPFCNPJ;
    private AddressResponseId ENDERECO;
    private ContactResponseId CONTATO;
    private RepresentativeResponseId REPRESENTANTE;
    private ContractOnlyIdResponse CONTRATO;
}
