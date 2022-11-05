package br.com.proonto.models.responses;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DajeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String EMISSOR;
    private String NUMERO;
    private String SERIE;
    private Double VALOR;
    private String ISENTO;
    private String JUSTIFICATIVA;
}
