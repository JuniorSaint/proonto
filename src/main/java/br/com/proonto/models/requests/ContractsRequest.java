package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Contract;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
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