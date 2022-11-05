package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "immovables")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Immovable extends RepresentationModel<Immovable> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DADOSARRENDAMENTO;
    private String EDIFICACAO;
    @Column(columnDefinition = "TEXT")
    private String DESCRICAO;
    @OneToOne
    @JoinColumn(name = "tipo_localizacao_id", referencedColumnName = "domain")
    private LocationType TIPOLOCALIZACAO;
    @OneToOne
    @JoinColumn(name = "tipo_imovel_id", referencedColumnName = "domain")
    private PropertyType TIPOIMOVEL;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToOne(mappedBy = "immovable", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address ENDERECO;
}
