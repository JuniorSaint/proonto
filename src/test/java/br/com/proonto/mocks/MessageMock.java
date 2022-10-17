package br.com.proonto.mocks;

import java.time.Instant;

public interface MessageMock {
    Long ID = 1L;
    public static final Long ID_NULL = null;
    Long ID_ZERO = 0L;

    Long ID_NO_EXIST = 1000000L;
    String ID_STRING = "001";
    public static final Instant CREATED_AT = Instant.now();
    public static final Instant UPDATED_AT = Instant.now();

    public static final String  DOMAIN = "01";
    public static final String EMAIL = "junior@idip.com.br";


    public static final String IMMOVABLE_DELETE = "Immovable with id " + ID + ", was deleted with success.";
    public static final String CREDITOR_DELETE = "Creditor with id " + ID + ", was deleted with success.";
    public static final String BANK_DELETE = "Bank with id " + ID + ", was deleted with success.";
    public static final String AGENCY_DELETE = "Agency bank with id " + ID + ", was deleted with success.";
    public static final String GUARANTEE_TYPE_SUB_DELETE = "Guarantee type sub with id " + ID + ", was deleted with success.";
    public static final String PROPERTY_TYPE_DELETE = "Property type sub with id " + ID + ", was deleted with success.";
    public static final String GUARANTEE_TYPE_DELETE = "Guarantee Type with id " + ID + ", was deleted with success.";
    public static final String USER_DELETE = "User with id " + ID + ", was deleted with success.";
    public static final String CREDITOR_NOT_FOUND = "Creditor with id - " + ID + " - not found, verify and try again ";
    public static final String MESSAGE_NOT_FOUND_DEBTOR = "Debtor not found, verify and try again - " + ID_ZERO;
    public static final String MESSAGE_NOT_FOUND_IMMOVAVLE = "Immovable not found, verify and try again - " + ID_ZERO;
    public static final String MESSAGE_NOT_FOUND_AGENCY = "Agency bank not found, verify and try again - " + ID_ZERO;
    public static final String MESSAGE_NOT_FOUND_BANK = "Bank not found, verify and try again - id: " + ID_ZERO;
    public static final String MESSAGE_NOT_FOUND_GUARANTEE_TYPE = "Guarantee type not found, verify and try again - " ;
    public static final String MESSAGE_NOT_FOUND_GUARANTEE_TYPE_SUB = "Guarantee type sub not found, verify and try again - ";
}
