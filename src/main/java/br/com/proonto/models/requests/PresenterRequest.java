package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.models.entities.PersonType;
import br.com.proonto.models.entities.Representative;
import br.com.proonto.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PresenterRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String NOME;
    private PersonTypeRequest TIPOPESSOA;
    private String CPFCNPJ;
    private AddressRequest ENDERECO;
    private ContactRequest CONTATO;
    private RepresentativeRequest REPRESENTANTE;
}
