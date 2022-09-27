package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DajeResponseId extends DajeResponse {
    private static final long serialVersionUID = 1L;
    private Long id;
}
