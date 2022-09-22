package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Area;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class FileResponse {
    private String NOME;
    private String TIPO;
    private Area AREA;
}
