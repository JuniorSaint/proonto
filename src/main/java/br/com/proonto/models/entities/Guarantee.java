package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "guarantees")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Guarantee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "tipo_garantia_id", referencedColumnName = "id")
    private GuaranteeTypeSub TIPOGARANTIA;
    @OneToOne
    @JoinColumn(name = "tipo_bem_id", referencedColumnName = "domain")
    private PropertyType TIPOBEM;
    @Column(columnDefinition = "TEXT")
    private String DESCRICAO;
    private Double PERCENTUALCOMPROMETIDO;
    private Double VALOR;
    private String QUALIDADE;
    private Integer QUANTIDADE;
    private String MARCA;
    private String PERIODOPRODUCAO;
    private String GRAU;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area AREA;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "registro_id")
    private List<Registry> REGISTROS;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contract CONTRATO;
}
