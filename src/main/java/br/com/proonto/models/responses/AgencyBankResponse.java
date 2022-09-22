package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Bank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AgencyBankResponse {
    private String agency;
    private String count;
    private Boolean active;
    private BankResponseId bank;
    private ContactResponseId contact;
}
