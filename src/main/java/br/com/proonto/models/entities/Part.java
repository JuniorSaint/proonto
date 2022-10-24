package br.com.proonto.models.entities;

import br.com.proonto.models.enums.CreditorTypeEnum;
import br.com.proonto.models.enums.GenderType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "parts")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Part extends RepresentationModel<Part> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NOME;
    @OneToOne
    @JoinColumn(name = "tipo_pessoa_id", referencedColumnName = "domain")
    private PersonType TIPOPESSOA;
    private String CPFCNPJ;
    private GenderType GENERO;
    private LocalDate DATANASCIMENTO;
    private String DOCUMENTO;
    private String ORGAOEMISSOR;
    private String NACIONALIDADE;
    private String UNIAOESTAVEL;
    @OneToOne
    @JoinColumn(name = "outro_regime_id", referencedColumnName = "domain")
    private PropertyRegime OUTROREGIME;
    @OneToOne
    @JoinColumn(name = "estado_civil_id", referencedColumnName = "domain")
    private MaritalStatus ESTADOCIVIL;
    @OneToOne
    @JoinColumn(name = "regime_bens_id", referencedColumnName = "domain")
    private PropertyRegime REGIMEBENS;
    private String PROFISSAO;
    private String FILIACAO1;
    private String FILIACAO2;
    private String CPFCONJUGE;


    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public void setTIPOPESSOA(PersonType TIPOPESSOA) {
        this.TIPOPESSOA = TIPOPESSOA;
    }

    public void setCPFCNPJ(String CPFCNPJ) {
        if(CPFCNPJ == null){
            this.CPFCNPJ = CPFCNPJ;
        }else{
            this.CPFCNPJ = CPFCNPJ.replaceAll("\\D", "");
        }
    }

    public void setGENERO(GenderType GENERO) {
        this.GENERO = GENERO;
    }

    public void setDATANASCIMENTO(LocalDate DATANASCIMENTO) {
        this.DATANASCIMENTO = DATANASCIMENTO;
    }

    public void setDOCUMENTO(String DOCUMENTO) {
        this.DOCUMENTO = DOCUMENTO;
    }

    public void setORGAOEMISSOR(String ORGAOEMISSOR) {
        this.ORGAOEMISSOR = ORGAOEMISSOR;
    }

    public void setNACIONALIDADE(String NACIONALIDADE) {
        this.NACIONALIDADE = NACIONALIDADE;
    }

    public void setUNIAOESTAVEL(String UNIAOESTAVEL) {
        this.UNIAOESTAVEL = UNIAOESTAVEL;
    }

    public void setOUTROREGIME(PropertyRegime OUTROREGIME) {
        this.OUTROREGIME = OUTROREGIME;
    }

    public void setESTADOCIVIL(MaritalStatus ESTADOCIVIL) {
        this.ESTADOCIVIL = ESTADOCIVIL;
    }

    public void setREGIMEBENS(PropertyRegime REGIMEBENS) {
        this.REGIMEBENS = REGIMEBENS;
    }

    public void setPROFISSAO(String PROFISSAO) {
        this.PROFISSAO = PROFISSAO;
    }

    public void setFILIACAO1(String FILIACAO1) {
        this.FILIACAO1 = FILIACAO1;
    }

    public void setFILIACAO2(String FILIACAO2) {
        this.FILIACAO2 = FILIACAO2;
    }

    public void setCPFCONJUGE(String CPFCONJUGE) {

        if(CPFCONJUGE == null){
            this.CPFCONJUGE = CPFCONJUGE;
        }else{
            this.CPFCONJUGE = CPFCONJUGE.replaceAll("\\D", "");
        }
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setENDERECO(Address ENDERECO) {
        this.ENDERECO = ENDERECO;
    }

    public void setQUALIFICACOES(List<PartsRole> QUALIFICACOES) {
        this.QUALIFICACOES = QUALIFICACOES;
    }

    public void setCONTATO(Contact CONTATO) {
        this.CONTATO = CONTATO;
    }

    public void setCONTRATO(Contract CONTRATO) {
        this.CONTRATO = CONTRATO;
    }
}
