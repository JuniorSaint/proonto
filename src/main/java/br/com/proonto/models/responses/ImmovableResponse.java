package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImmovableResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String EDIFICACAO;
    private String DESCRICAO;
    private LocationTypeResponse TIPOLOCALIZACAO;
    private PropertyTypeResponseId TIPOIMOVEL;
    private AddressResponseId ENDERECO;
    private String DADOSARRENDAMENTO;
}
