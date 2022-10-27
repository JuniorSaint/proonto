package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.entities.Creditor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AgencyBankResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String agency;
    private String count;
    private Boolean active;
    private BankResponseId bank;
    private ContactResponseId contact;
    private CreditorMatrixResponse creditor;
}
