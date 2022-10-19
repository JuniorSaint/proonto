package br.com.proonto.models.requests;

import lombok.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContractsRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String VERSAO;
    private String VERSAODADOS;
    private List<ContractRequest> CONTRATOS;
}