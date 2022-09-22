package br.com.proonto.models.requests;

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
    private GuaranteeRequest GUARANTEE;
}
