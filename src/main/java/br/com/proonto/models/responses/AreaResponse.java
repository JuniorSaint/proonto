package br.com.proonto.models.responses;

import br.com.proonto.models.requests.FileRequest;
import br.com.proonto.models.requests.GuaranteeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AreaResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String DESCRICAO;
    private List<FileResponse> ARQUIVOS;
}
