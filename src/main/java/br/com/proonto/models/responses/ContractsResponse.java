package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ContractsResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String VERSAO;
    private String VERSAODADOS;
    private List<ContractResponseId> CONTRATOS;
}