package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClauseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String CLAUSULA;
}
