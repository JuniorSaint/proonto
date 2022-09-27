package br.com.proonto.models.responses;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatesTableResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ufCode;
    private String federationUnity;
    private String state;
}

