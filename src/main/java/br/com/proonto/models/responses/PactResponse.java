package br.com.proonto.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PactResponse {
    private String CARTORIO;
    private String LOCAL;
    private LocalDate DATA;
    private String REGISTRO;
    private String LIVRO;
    private String FOLHA;
}