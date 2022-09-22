package br.com.proonto.models.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum CreditorTypeEnum {
    MATRIX(1, "matrix"),
    BRANCH(2, "branch");

    private final Integer guid;
    private final String description;
}