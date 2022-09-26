package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LocationProductionResponse {
    private Long id;
    private RegistryResponse REGISTRO;
}
