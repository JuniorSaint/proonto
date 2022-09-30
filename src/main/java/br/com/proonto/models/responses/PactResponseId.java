package br.com.proonto.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PactResponseId extends PactResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}