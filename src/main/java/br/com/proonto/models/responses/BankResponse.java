package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BankResponse {
    private String code;
    private String ispb;
    private String cnpj;
    private String nameBank;
    private String url;
}
