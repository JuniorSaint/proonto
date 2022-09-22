package br.com.proonto.mocks;

import br.com.proonto.models.requests.AgencyBankRequest;

import static br.com.proonto.mocks.BankMock.BANK;
import static br.com.proonto.mocks.ContactMock.CONTACT;

public interface AgencyBankMock {
    public static final Long ID_AGENCY = 1L;
    public static final String AGENCY = "agencia 255";
    public static final String COUNT = "12541253";
//    public static final AgencyBank AGENCY_BANK = new AgencyBank(ID_BANK, AGENCY, COUNT, true, CREATED_AT, UPDATED_AT, BANK);
    public static final AgencyBankRequest AGENCY_BANK_REQUEST = new AgencyBankRequest(ID_AGENCY, AGENCY, COUNT, true, BANK, CONTACT);
}
