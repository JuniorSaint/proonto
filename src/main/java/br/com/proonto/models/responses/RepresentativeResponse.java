package br.com.proonto.models.responses;

import br.com.proonto.models.requests.PresenterRepresentativeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RepresentativeResponse {
    private String NOME;
    private String CPFCNPJ;
}
