package br.com.proonto.models.entities;

import br.com.proonto.models.enums.CreditorTypeEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "creditors")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Creditor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NOME;
    @OneToOne
    @JoinColumn(name = "tipo_pessoa_id", referencedColumnName = "domain")
    private PersonType TIPOPESSOA;
    private String CPFCNPJ;
    private CreditorTypeEnum TIPODECREDOR;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parameter_id", referencedColumnName = "id")
    private Parameter parameter;

    @OneToMany(mappedBy = "creditor")
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "matrix_id", referencedColumnName = "id")
    private Creditor matrix;

    @OneToOne
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    private Template template;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Address ENDERECO;

    @OneToMany(mappedBy="part")
    private List<PartsRole> QUALIFICACOES;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contact CONTATO;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contract CONTRATO;

    @OneToMany(mappedBy="creditor")
    private Set<AgencyBank> agencyBanks;

    @OneToMany(mappedBy="creditor")
    private Set<Template> templates;

    public void setCPFCNPJ(String CPFCNPJ) {
        if (CPFCNPJ == null) {
            this.CPFCNPJ = CPFCNPJ;
        } else {
            this.CPFCNPJ = CPFCNPJ.replaceAll("\\D", "");
        }
    }

}