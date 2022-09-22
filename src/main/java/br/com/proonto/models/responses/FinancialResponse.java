package br.com.proonto.models.responses;

import br.com.proonto.models.requests.CPRRequest;
import br.com.proonto.models.requests.ContractRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FinancialResponse {
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
