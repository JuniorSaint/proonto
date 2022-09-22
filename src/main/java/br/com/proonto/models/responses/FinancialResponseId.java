package br.com.proonto.models.responses;

import br.com.proonto.models.requests.CPRRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FinancialResponseId extends FinancialResponse {
    private Long id;
}
