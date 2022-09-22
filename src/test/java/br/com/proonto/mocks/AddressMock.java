package br.com.proonto.mocks;

import br.com.proonto.models.entities.Address;

public interface AddressMock {
    public static final String STREET = "Rua das Acácias";
    public static final Long ID_ADDRESS = 2L;
    public static final String NUMBER = "25B";
    public static final String DISTRICT = "Centro";
    public static final String CITY = "Carandaí";
    public static final String UF = "MG";
    public static final String ZIP_CODE = "36000-00";
    public static final String BATCH = "Lote C";
    public static final String TOWER = "Bloco E";
    public static final String SQUARE = "Quadra E";

    public static final String COMPLEMENT = "Sem Complemento";

    public static final Address ADDRESS = Address.builder().TIPOLOGRADOURO("1").LOGRADOURO(STREET).id(ID_ADDRESS)
            .NUMERO(NUMBER).BAIRRO(DISTRICT).CIDADE(CITY).UF(UF).CEP(ZIP_CODE).LOTE(BATCH)
            .COMPLEMENTO(COMPLEMENT).TORRE(TOWER).QUADRA(SQUARE).build();
}
