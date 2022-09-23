package br.com.proonto.models.requests;

import br.com.proonto.models.entities.FileArea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class FilesRequest {
    private Long id;
    List<FileRequest> ARQUIVOS;
}
