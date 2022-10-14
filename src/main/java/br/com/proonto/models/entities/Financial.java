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
    @OneToOne
    @JoinColumn(name = "moeda_id", referencedColumnName = "domain")
    private Currency MOEDA;
    private Double SALDOREMANESCENTE;
    private Double VALORPARCELAINICIAL;
    @Column(columnDefinition = "TEXT")
    private String FORMAPAGAMENTO;
    private Double TAXAJUROSNOMINALANUAL;
    private String TAXAJUROSNOMINALANUALPOREXTENSO;
    private Double TAXAJUROSNOMINALMENSAL;
    private String TAXAJUROSNOMINALMENSALPOREXTENSO;
    private Double TAXAJUROSEFETIVAMENSAL;
    private String TAXAJUROSEFETIVAMENSALPOREXTENSO;
    private Double TAXAJUROSEFETIVAANUAL;
    private String TAXAJUROSEFETIVAANUALPOREXTENSO;
    private String PRACAPAGAMENTO;
    private String FORO;
    @OneToOne
    @JoinColumn(name = "indexador_id", referencedColumnName = "id")
    private IndexerSub INDEXADOR;
    private String COMISSAOFISCALIZACAO;
    private Double MULTA;
    private String MULTAPOREXTENSO;
}
