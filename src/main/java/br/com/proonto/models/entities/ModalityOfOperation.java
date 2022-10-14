package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "modalityOfOperation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class ModalityOfOperation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "modalidade_id", referencedColumnName = "id")
    private ModalityOfTheOperationSub MODALIDADE;
    @OneToOne
    @JoinColumn(name = "origem_recursos_id", referencedColumnName = "id")
    private ResourcesOriginSub ORIGEMRECURSOS;
    private String DESTINOFINANCIAMENTO;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contract CONTRATO;
}
