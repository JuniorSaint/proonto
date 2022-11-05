package br.com.proonto.models.responses;


import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistryOfficeResponseId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String CNS;
    private String NOME;
    private String COMARCA;
    private String UF;
}
