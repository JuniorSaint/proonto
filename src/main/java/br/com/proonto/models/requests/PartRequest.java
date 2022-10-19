package br.com.proonto.models.requests;

import br.com.proonto.models.entities.*;
import br.com.proonto.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PartRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String NOME;
    private PersonTypeRequest TIPOPESSOA;
    private String CPFCNPJ;
    private GenderType GENERO;
    private LocalDate DATANASCIMENTO;
    private String DOCUMENTO;
    private String ORGAOEMISSOR;
    private String NACIONALIDADE;
    private String UNIAOESTAVEL;
    private PropertyRegimeRequest OUTROREGIME;
    private MaritalStatusRequest ESTADOCIVIL;
    private PropertyRegimeRequest REGIMEBENS;
    private String PROFISSAO;
    private String FILIACAO1;
    private String FILIACAO2;
    private String CPFCONJUGE;
    private AddressRequest ENDERECO;
    private List<PartsRoleRequest> QUALIFICACOES;
    private ContactRequest CONTATO;
}
