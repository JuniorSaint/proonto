package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.entities.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AgencyBankRequest {
    private Long id;
    private String agency;
    private String count;
    private Boolean active;
    private BankRequest bank;
    private ContactRequest contact;
}
