package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryResponseId extends DictionaryResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}