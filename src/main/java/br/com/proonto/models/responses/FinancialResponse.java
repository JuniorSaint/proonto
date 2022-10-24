package br.com.proonto.models.responses;

import br.com.proonto.models.entities.IndexerSub;
import br.com.proonto.models.requests.CPRRequest;
import br.com.proonto.models.requests.ContractRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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
