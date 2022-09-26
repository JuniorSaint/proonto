package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Area;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class FileRequest {
    private Long id;
    private String NOME;
    private String TIPO;
}
