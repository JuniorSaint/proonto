package br.com.proonto.models.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String LOGRADOURO;
    private String NUMERO;
    private String BAIRRO;
    private String CIDADE;
    private String UF;
    private String LOTE;
    private String QUADRA;
    private String TORRE;
    private String COMPLEMENTO;
    private String CEP;

    @OneToOne
    @JoinColumn(name = "address_type_id", referencedColumnName = "code")
    private AddressType TIPOLOGRADOURO;

    @OneToOne
    @JoinColumn(name = "immovable_id", referencedColumnName = "id")
    private Immovable immovable;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLOGRADOURO(String LOGRADOURO) {
        this.LOGRADOURO = LOGRADOURO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public void setCIDADE(String CIDADE) {
        this.CIDADE = CIDADE;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setLOTE(String LOTE) {
        this.LOTE = LOTE;
    }

    public void setQUADRA(String QUADRA) {
        this.QUADRA = QUADRA;
    }

    public void setTORRE(String TORRE) {
        this.TORRE = TORRE;
    }

    public void setCOMPLEMENTO(String COMPLEMENTO) {
        this.COMPLEMENTO = COMPLEMENTO;
    }

    public void setCEP(String CEP) {
        if(CEP == null){
            this.CEP = CEP;
        }else{
            this.CEP = CEP.replaceAll("\\D", "");
        }
    }

    public void setTIPOLOGRADOURO(AddressType TIPOLOGRADOURO) {
        this.TIPOLOGRADOURO = TIPOLOGRADOURO;
    }
}
