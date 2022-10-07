package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TemplateResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String body;
}