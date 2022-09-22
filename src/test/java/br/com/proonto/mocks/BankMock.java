package br.com.proonto.mocks;

import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.requests.BankRequest;

import java.time.LocalDate;
import java.util.Optional;

import static br.com.proonto.mocks.MessageMock.*;

public interface BankMock {
    public static final String CODE = "001";
    public static final String ISPB = "00000001";
    public static final String CNPJ_BANK = "25258258000366";
    public static final String NAME_BANK = "Banco Santo Atanázio";
    public static final String URL = "www.bancosantoatanazio.com.br";
    public static final Bank BANK = new Bank(ID, CODE, ISPB, CNPJ_BANK, NAME_BANK, URL, CREATED_AT, UPDATED_AT);
}
