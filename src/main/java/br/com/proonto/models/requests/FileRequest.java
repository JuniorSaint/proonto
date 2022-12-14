package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class FileRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String NOME;
    private String TIPO;
}
