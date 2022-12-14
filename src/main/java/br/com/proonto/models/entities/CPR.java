package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Entity
@Table(name = "cprs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class CPR implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String LOCALENTREGA;
    private String PERIODO;
    private String CONDICOES;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> PRODUTOS;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "financeiro_id", referencedColumnName = "id")
    private Financial FINANCEIRO;

    @OneToOne
    @JoinColumn(name = "contrato_id")
    private Contract CONTRATO;
}
