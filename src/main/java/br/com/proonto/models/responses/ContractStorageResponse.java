package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractStorageResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String storage;
    private Contract contract;
}