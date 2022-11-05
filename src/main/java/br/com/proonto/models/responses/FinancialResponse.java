package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Double VALORTOTAL;
    private String VALOREXTENSO;
    private String CRITERIOOBTENCAOLIQUIDACAO;
    private CurrencyResponse MOEDA;
    private Double SALDOREMANESCENTE;
    private Double VALORPARCELAINICIAL;
    private String FORMAPAGAMENTO;
    private Double TAXAJUROSNOMINALANUAL;
    private Double TAXAJUROSNOMINALMENSAL;
    private Double TAXAJUROSEFETIVAMENSAL;
    private Double TAXAJUROSEFETIVAANUAL;
    private String PRACAPAGAMENTO;
    private String FORO;
    private IndexerSubResponse INDEXADOR;
    private String COMISSAOFISCALIZACAO;
    private ContractOnlyIdResponse CONTRATO;
}
