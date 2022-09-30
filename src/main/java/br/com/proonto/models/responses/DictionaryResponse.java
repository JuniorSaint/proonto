package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private Boolean active;
}