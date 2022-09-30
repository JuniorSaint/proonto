package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Area;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FileResponseId extends FileResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
