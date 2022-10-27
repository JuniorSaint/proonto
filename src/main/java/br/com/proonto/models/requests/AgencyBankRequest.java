package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Creditor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AgencyBankRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String agency;
    private String count;
    private Boolean active;
    private BankRequest bank;
    private ContactRequest contact;
    private CreditorMatrixRequest creditor;
}
