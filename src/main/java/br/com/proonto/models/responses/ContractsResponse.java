package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractsResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String VERSAO;
    private String VERSAODADOS;
    private List<ContractResponseId> CONTRATOS;
}