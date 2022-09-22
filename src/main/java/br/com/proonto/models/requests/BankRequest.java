package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BankRequest {
    private Long id;
    private String code;
    private String ispb;
    private String cnpj;
    private String nameBank;
    private String url;
}
