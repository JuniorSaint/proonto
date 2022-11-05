package br.com.proonto.models.entities;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pignoratics implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dueDateUnabbreviated;
    private String headerTitle;
    private String cityStateDateOfContract;
    private String contractNumber;
    private String typeOfBanknote;
    private Double value;
    private String valueUnabbreviated;
    private String creditor;
    private String cnpjCreditor;
    private String typeStreetCreditor;
    private String streetCreditor;
    private String numberCreditor;
    private String districtCreditor;
    private String cityCreditor;
    private String ufCreditor;
    private String zipCodeCreditor;
    private Double effectiveInterestPerYear;
    private Double effectiveInterestPerMonth;
    private String effectiveInterestPerYearUnabbreviated;
    private String effectiveInterestPerMonthUnabbreviated;
    private Double fine;
    private String fineUnabbreviated;
    private Integer amount;
    private String description;
    private String grade;
    private String harvest;
    private String humidity;
    private String impurities;
    private String damagedAndBurnt;
    private String typeStreetGuarantee;
    private String streetGuarantee;
    private String immovableRegister;
    private String numberGuarantee;
    private String districtGuarantee;
    private String cityGuarantee;
    private String ufGuarantee;
    private String zipCodeGuarantee;
    private String county;
    private String cns;
    private String cnsUfGuarantee;
    private String cnsCityGuarantee;
    private String ufRegistry;
    private String faithfulDepositary;
    private String maritalStatusfaithful;
    private String cpfFaithful;
    private String streetFaithful;
    private String numberFaithful;
    private String districtFaithful;
    private String cityFaithful;
    private String ufFaithful;
    private String zipCodeFaithful;
    private String debtor;
    private String maritalStatusDebtor;
    private String cpfDebtor;
    private String streetDebtor;
    private String numberDebtor;
    private String districtDebtor;
    private String cityDebtor;
    private String ufDebtor;
    private String zipCodeDebtor;
    private LocalDate birthdayDebtor;
    private String documentDebtor;
    private String issuingAgencyDebtor;
    private String nacionalityDebtor;
    private String propertyRegimeDebtor;
    private String profissionDebtor;
    private String filiation1Debtor;
    private String filiation2Debtor;
    private String cpfSpouseDebtor;
}