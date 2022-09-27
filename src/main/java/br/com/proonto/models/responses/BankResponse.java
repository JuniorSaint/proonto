package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class BankResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String ispb;
    private String cnpj;
    private String nameBank;
    private String url;
}
