package br.com.proonto.models.responses;

import br.com.proonto.models.requests.CPRRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FinancialResponseId extends FinancialResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String TAXAJUROSNOMINALANUALPOREXTENSO;
    private String TAXAJUROSNOMINALMENSALPOREXTENSO;
    private String TAXAJUROSEFETIVAMENSALPOREXTENSO;
    private String TAXAJUROSEFETIVAANUALPOREXTENSO;
}
