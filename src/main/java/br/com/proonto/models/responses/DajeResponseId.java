package br.com.proonto.models.responses;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DajeResponseId extends DajeResponse {
    private static final long serialVersionUID = 1L;
    private Long id;
}
