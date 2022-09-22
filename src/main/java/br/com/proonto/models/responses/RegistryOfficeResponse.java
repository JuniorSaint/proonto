package br.com.proonto.models.responses;


import br.com.proonto.models.requests.ContractRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegistryOfficeResponse {
    private String CNS;
    private String NOME;
}
