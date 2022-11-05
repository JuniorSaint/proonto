package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;
    private LocationProductionResponseId LOCALPRODUCAO;
}
