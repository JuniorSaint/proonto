package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuaranteeTypeSubResponseId extends GuaranteeTypeSubResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
}