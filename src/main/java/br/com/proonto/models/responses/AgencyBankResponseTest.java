package br.com.proonto.models.responses;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"active", "count", "agency", "bank"})
public interface AgencyBankResponseTest extends Serializable {
    static final long serialVersionUID = 1L;

    String getAgency();

    String getCount();

    Boolean getActive();

    BankResponseIdTest getBank();

    ContactResponseTest getContact();

    CreditorMatrixResponseForBranchTest getCreditor();
}
