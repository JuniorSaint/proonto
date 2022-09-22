package br.com.proonto.models.requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorizationRequest {
    private Long id;
    private String DECLARO;
    private String AUTORIZO;
    private ContractRequest CONTRATO;
}
