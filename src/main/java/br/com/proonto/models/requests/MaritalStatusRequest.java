package br.com.proonto.models.requests;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaritalStatusRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String domain;
}