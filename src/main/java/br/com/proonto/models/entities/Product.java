package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;

    @ManyToOne
    @JoinColumn(name="cpr_id")
    private CPR CPR;

    @OneToOne
    @MapsId
    @JoinColumn(name = "local_producao_id")
    private Registry LOCALPRODUCAO;
}