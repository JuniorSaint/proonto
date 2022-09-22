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
import java.time.LocalDate;

@Entity
@Table(name = "financial")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Financial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double VALORTOTAL;
    private String VALOREXTENSO;
    private String CRITERIOOBTENCAOLIQUIDACAO;
    private String MOEDA;
    private Double SALDOREMANESCENTE;
    private Double VALORPARCELAINICIAL;
    @Column(columnDefinition = "TEXT")
    private String FORMAPAGAMENTO;
    private Double TAXAJUROSNOMINALANUAL;
    private Double TAXAJUROSNOMINALMENSAL;
    private Double TAXAJUROSEFETIVAMENSAL;
    private Double TAXAJUROSEFETIVAANUAL;
    private String PRACAPAGAMENTO;
    private String FORO;
    private String INDEXADOR;
    private String COMISSAOFISCALIZACAO;

    @OneToOne(mappedBy = "FINANCEIRO")
    private CPR CPR;

    @OneToOne(mappedBy = "FINANCEIRO")
    private Contract CONTRATO;
}
