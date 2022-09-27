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
@Table(name = "daje")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Daje implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String EMISSOR;
    private String NUMERO;
    private String SERIE;
    private Double VALOR;
    private String ISENTO;
    @Column(columnDefinition = "TEXT")
    private String JUSTIFICATIVA;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contract CONTRATO;
}
