package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "descricao", "contrato", "percentualcomprometido", "valor", "qualidade", "quantidade", "marca", "periodoproducao",
        "grau", "tipogarantia", "tipobem", "area", "registros"})
public class GuaranteeResponseId extends GuaranteeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
