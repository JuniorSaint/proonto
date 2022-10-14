package br.com.proonto.models.requests;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressTypeRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
}
