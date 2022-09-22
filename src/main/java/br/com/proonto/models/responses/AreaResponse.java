package br.com.proonto.models.responses;

import br.com.proonto.models.requests.FileRequest;
import br.com.proonto.models.requests.GuaranteeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AreaResponse {
    private String DESCRICAO;
    private List<FileResponse> ARQUIVOS;
    private GuaranteeResponse GUARANTEE;
}
