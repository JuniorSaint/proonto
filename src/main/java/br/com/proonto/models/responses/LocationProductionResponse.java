package br.com.proonto.models.responses;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationProductionResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private RegistryResponseId REGISTRO;
}
