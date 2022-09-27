package br.com.proonto.models.responses;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class RegistryOfficeResponseId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String CNS;
    private String NOME;
}
