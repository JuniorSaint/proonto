package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Dajes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DajeRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String EMISSOR;
    private String NUMERO;
    private String SERIE;
    private Double VALOR;
    private String ISENTO;
    private String JUSTIFICATIVA;
    private Dajes DAJES;
}
