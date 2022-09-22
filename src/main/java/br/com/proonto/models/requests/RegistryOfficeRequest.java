package br.com.proonto.models.requests;


import br.com.proonto.models.entities.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegistryOfficeRequest{

    private Long id;
    private String CNS;
    private String NOME;
    private ContractRequest CONTRATO;
}
