package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.entities.Parameter;
import br.com.proonto.models.entities.Template;
import br.com.proonto.models.enums.CreditorTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreditorRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String NOME;
    private String TIPOPESSOA;
    private String CPFCNPJ;
    private AddressRequest ENDERECO;
    private List<QualificationRequest> QUALIFICACOES;
    private ContactRequest CONTATO;
    private CreditorTypeEnum typeFiliation;
    private Parameter parameter;
    private Creditor branch;
    private Template template;
}
