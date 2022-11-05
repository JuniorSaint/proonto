package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
