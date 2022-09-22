package br.com.proonto.models.requests;

import br.com.proonto.models.entities.PresenterRepresentative;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RepresentativeRequest{

    private Long id;
    private String NOME;
    private String CPFCNPJ;
}
