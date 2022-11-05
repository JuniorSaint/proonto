package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "localentrega", "periodo", "condicoes", "contrato", "financeiro", "produtos"})
public class CPRResponseId extends CPRResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
