package br.com.proonto.models.requests;

import br.com.proonto.models.entities.FileArea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AreaRequest {
    private Long id;
    private String DESCRICAO;
    private List<FileRequest> ARQUIVOS;
}
