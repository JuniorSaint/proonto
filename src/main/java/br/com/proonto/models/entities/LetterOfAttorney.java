package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "letterOfAttorney")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LetterOfAttorney implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String REPRESENTANTE;
    private String REPRESENTADO;
    private String NUMERO;
    private String TIPOREGISTRO;
    private String ORGAO;
    private String FORMAREGISTRO;
    private String NUMEROLIVRO;
    private String FOLHA;
    private String NUMEROREGISTRO;
    private LocalDate DATAREGISTRO;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contract CONTRATO;
}
