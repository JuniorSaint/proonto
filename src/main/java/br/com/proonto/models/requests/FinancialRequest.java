package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Currency;
import br.com.proonto.models.entities.IndexerSub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FinancialRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotBlank(message = "Value is a mandatory field")
    private Double VALORTOTAL;
    @NotBlank(message = "Value in extensive is a mandatory field")
    private String VALOREXTENSO;
    private String CRITERIOOBTENCAOLIQUIDACAO;
    private Currency MOEDA;
    private Double SALDOREMANESCENTE;
    private Double VALORPARCELAINICIAL;
    private String FORMAPAGAMENTO;
    private String TAXAJUROSNOMINALANUALPOREXTENSO;
    private Double TAXAJUROSNOMINALMENSAL;
    private String TAXAJUROSNOMINALMENSALPOREXTENSO;
    private Double TAXAJUROSEFETIVAMENSAL;
    private String TAXAJUROSEFETIVAMENSALPOREXTENSO;
    private Double TAXAJUROSEFETIVAANUAL;
    private String TAXAJUROSEFETIVAANUALPOREXTENSO;
    private String PRACAPAGAMENTO;
    private String FORO;
    private IndexerSub INDEXADOR;
    private String COMISSAOFISCALIZACAO;
    private Double MULTA;
    private String MULTAPOREXTENSO;
}
