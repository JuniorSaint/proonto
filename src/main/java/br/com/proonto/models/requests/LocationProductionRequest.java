package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LocationProductionRequest {
    private Long id;
    private RegistryRequest REGISTRO;
}
