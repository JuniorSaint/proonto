package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditorMatrixResponseForBranch implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}