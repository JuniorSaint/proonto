package br.com.proonto.models.requests;

import br.com.proonto.models.entities.*;
import br.com.proonto.models.entities.Parameter;
import br.com.proonto.models.enums.CreditorTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreditorMatrixRequest  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @NotBlank (message = "Name is a mandatory field")
    private String NOME;
    private PersonType TIPOPESSOA;
    @NotBlank (message = "CNPF is a mandatory field")
    private String CPFCNPJ;
    private CreditorTypeEnum TIPODECREDOR;
    private Parameter parameter;
    private List<UserRequestPost> users;
    private TemplateRequest template;
    private AddressRequest ENDERECO;
    private List<QualificationRequest> QUALIFICACOES;
    private ContactRequest CONTATO;
}
