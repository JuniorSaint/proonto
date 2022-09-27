package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FinancialRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Double VALORTOTAL;
    private String VALOREXTENSO;
    private String CRITERIOOBTENCAOLIQUIDACAO;
    private String MOEDA;
    private Double SALDOREMANESCENTE;
    private Double VALORPARCELAINICIAL;
    private String FORMAPAGAMENTO;
    private Double TAXAJUROSNOMINALANUAL;
    private Double TAXAJUROSNOMINALMENSAL;
    private Double TAXAJUROSEFETIVAMENSAL;
    private Double TAXAJUROSEFETIVAANUAL;
    private String PRACAPAGAMENTO;
    private String FORO;
    private String INDEXADOR;
    private String COMISSAOFISCALIZACAO;
}
