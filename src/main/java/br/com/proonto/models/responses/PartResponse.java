package br.com.proonto.models.responses;

import br.com.proonto.models.entities.*;
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
public class PartResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private PersonTypeResponse TIPOPESSOA;
    private String CPFCNPJ;
    private GenderType GENERO;
    private LocalDate DATANASCIMENTO;
    private String DOCUMENTO;
    private String ORGAOEMISSOR;
    private String NACIONALIDADE;
    private String UNIAOESTAVEL;
    private PropertyRegimeResponse OUTROREGIME;
    private MaritalStatusResponse ESTADOCIVIL;
    private PropertyRegimeResponse REGIMEBENS;
    private String PROFISSAO;
    private String FILIACAO1;
    private String FILIACAO2;
    private String CPFCONJUGE;
    private AddressResponseId ENDERECO;
    private List<PartsRoleResponse> QUALIFICACOES;
    private ContactResponseId CONTATO;
    private ContractOnlyIdResponse CONTRATO;
}