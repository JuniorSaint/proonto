package br.com.proonto.models.responses;

import java.io.Serializable;

public interface BankResponseIdTest extends Serializable {
    static final long serialVersionUID = 1L;

    Long getId();

    String getCode();

    String getIspb();

    String getCnpj();

    String getNameBank();

    String getUrl();
}
