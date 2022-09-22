package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Dajes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DajeRequest {
    private Long id;
    private String EMISSOR;
    private String NUMERO;
    private String SERIE;
    private Double VALOR;
    private String ISENTO;
    private String JUSTIFICATIVA;
    private Dajes DAJES;
}
