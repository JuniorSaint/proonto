package br.com.proonto.models.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DajeResponse {
    private String EMISSOR;
    private String NUMERO;
    private String SERIE;
    private Double VALOR;
    private String ISENTO;
    private String JUSTIFICATIVA;
}
