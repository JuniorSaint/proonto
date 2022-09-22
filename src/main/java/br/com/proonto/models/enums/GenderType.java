package br.com.proonto.models.enums;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum GenderType {
    MASCULINO(1, "masculino"),
    FEMININO(2, "feminino");

    private final Integer guid;
    private final String description;
}
