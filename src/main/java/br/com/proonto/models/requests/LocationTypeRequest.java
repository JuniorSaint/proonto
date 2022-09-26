package br.com.proonto.models.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationTypeRequest {
    private String domain;
    private String description;
    private Boolean active;
}
