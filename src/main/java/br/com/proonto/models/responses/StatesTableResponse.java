package br.com.proonto.models.responses;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatesTableResponse {
    private String ufCode;
    private String federationUnity;
    private String state;
}

