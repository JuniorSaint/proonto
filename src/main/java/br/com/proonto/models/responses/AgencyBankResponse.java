package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AgencyBankResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String agency;
    private String count;
    private Boolean active;
    private BankResponseId bank;
    private ContactResponseId contact;
    private CreditorMatrixResponseForBranch creditor;
}
