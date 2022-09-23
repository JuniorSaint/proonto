package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "presenterRepresentative")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PresenterRepresentative implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NOME;
    private String TIPOPESSOA;
    private String CPFCNPJ;

    @OneToOne()
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Address ENDERECO;

    @OneToOne()
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contact CONTATO;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "representante_id", referencedColumnName = "id")
    private Representative REPRESENTANTE;

    @OneToOne(mappedBy = "REMETENTE")
    private Contract CONTRATOUM;

    @OneToOne(mappedBy = "APRESENTANTE")
    private Contract CONTRATODOIS;
}
