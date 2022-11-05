package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String ispb;
    private String cnpj;
    private String nameBank;
    private String url;
}
