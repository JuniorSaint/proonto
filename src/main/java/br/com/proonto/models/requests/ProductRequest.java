package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ProductRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String DESCRICAO;
    private String QUALIDADE;
    private String QUANTIDADE;
    private LocationProductionRequest LOCALPRODUCAO;
}
