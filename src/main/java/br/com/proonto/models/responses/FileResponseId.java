package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Area;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileResponseId extends FileResponse {
    private Long id;
}
