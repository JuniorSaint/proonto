package br.com.proonto.mocks;

import br.com.proonto.models.entities.PropertyType;

public interface PropertyTypeMock {
    public static final String DOMAIN = "001";
    public static final String DESCRIPTION_PROPERTY_TYPE = "Imóvel urbano residencial";

    public static final PropertyType PROPERTY_TYPE = new PropertyType(DOMAIN, DESCRIPTION_PROPERTY_TYPE, true);
}
