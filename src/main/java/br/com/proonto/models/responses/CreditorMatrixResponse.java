package br.com.proonto.models.responses;

import br.com.proonto.models.entities.*;
import br.com.proonto.models.enums.CreditorTypeEnum;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"nome", "tipopessoa", "cpfcnpj",  "parameter","endereco", "users", "contato", "agencyBanks"})
public class CreditorMatrixResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private PersonTypeResponse TIPOPESSOA;
    private String CPFCNPJ;
    private CreditorTypeEnum TIPODECREDOR;
    private Parameter parameter;
    private List<UserResponse> users;
    private Template template;
    private AddressResponseId ENDERECO;
    private List<PartsRoleResponse> QUALIFICACOES;
    private ContactResponseId CONTATO;
    private Set<AgencyBankResponseId> agencyBanks;
}