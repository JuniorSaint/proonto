package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.models.entities.PersonType;
import br.com.proonto.models.entities.Representative;
import br.com.proonto.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
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
