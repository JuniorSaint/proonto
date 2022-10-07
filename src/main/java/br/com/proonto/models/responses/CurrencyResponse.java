package br.com.proonto.models.responses;

import lombok.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String domain;
    private String description;
    private Boolean active;
}
