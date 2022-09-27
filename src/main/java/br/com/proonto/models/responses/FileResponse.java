package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FileResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String NOME;
    private String TIPO;
}
