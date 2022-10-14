package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "presenter")
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Presenter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NOME;
    @OneToOne
    @JoinColumn(name = "tipo_pessoa_id", referencedColumnName = "domain")
    private PersonType TIPOPESSOA;

    private String CPFCNPJ;
    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Address ENDERECO;
    @OneToOne
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contact CONTATO;
    @OneToOne
    @JoinColumn(name = "representante_id", referencedColumnName = "id")
    private Representative REPRESENTANTE;
}
