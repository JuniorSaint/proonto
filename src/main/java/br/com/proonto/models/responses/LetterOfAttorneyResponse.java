package br.com.proonto.models.responses;

import br.com.proonto.models.requests.ContractRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class LetterOfAttorneyResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String REPRESENTANTE;
    private String REPRESENTADO;
    private String NUMERO;
    private String TIPOREGISTRO;
    private String ORGAO;
    private String FORMAREGISTRO;
    private String NUMEROLIVRO;
    private String FOLHA;
    private String NUMEROREGISTRO;
    private LocalDate DATAREGISTRO;
}
