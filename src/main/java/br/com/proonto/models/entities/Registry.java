package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "registry")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Registry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CNS;
    private String LIVRO;
    private String NUMEROREGISTRO;
    private String COMPLEMENTO;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "imovel_id", referencedColumnName = "id")
    private Immovable IMOVEL;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Guarantee GUARANTEE;

    @OneToOne(mappedBy = "LOCALPRODUCAO", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Product PRODUTO;
}
