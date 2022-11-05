package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialResponseId extends FinancialResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String TAXAJUROSNOMINALANUALPOREXTENSO;
    private String TAXAJUROSNOMINALMENSALPOREXTENSO;
    private String TAXAJUROSEFETIVAMENSALPOREXTENSO;
    private String TAXAJUROSEFETIVAANUALPOREXTENSO;
    private Double MULTA;
    private String MULTAPOREXTENSO;
}
