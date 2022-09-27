package br.com.proonto.models.responses;

import br.com.proonto.models.requests.PresenterRepresentativeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class RepresentativeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private String CPFCNPJ;
}
