package br.com.proonto.models.requests;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class GuaranteeTypeSubRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
}