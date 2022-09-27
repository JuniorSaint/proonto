package br.com.proonto.models.requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorizationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String DECLARO;
    private String AUTORIZO;
    private ContractRequest CONTRATO;
}
