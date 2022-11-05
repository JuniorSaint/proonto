package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String DESCRICAO;
    private List<FileResponse> ARQUIVOS;
}
