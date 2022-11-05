package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private String TELEFONE;
    private String EMAIL;
}
