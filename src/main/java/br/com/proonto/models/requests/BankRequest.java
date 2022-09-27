package br.com.proonto.models.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class BankRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private String ispb;
    private String cnpj;
    private String nameBank;
    private String url;
}
