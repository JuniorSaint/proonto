package br.com.proonto.mocks;

import br.com.proonto.models.entities.GuaranteeType;
import br.com.proonto.models.entities.GuaranteeTypeSub;
import br.com.proonto.models.requests.GuaranteeTypeRequest;

import java.util.List;

import static br.com.proonto.mocks.GuaranteeTypeSubMock.GUARANTEE_TYPE_SUB;
import static br.com.proonto.mocks.MessageMock.*;

public interface GuaranteeTypeMock {
    public static final String DOMAIN_GUARANTEE = "01";
    public static final List<GuaranteeTypeSub> GUARANTEE_TYPE_SUB_LIST = List.of(GUARANTEE_TYPE_SUB);
    public static final String DESCRIPTION = "Acordos de Compensação";
    public static final GuaranteeType GUARANTEE_TYPE = new GuaranteeType(DOMAIN_GUARANTEE, DESCRIPTION, true, CREATED_AT, UPDATED_AT, GUARANTEE_TYPE_SUB_LIST);
    public static final GuaranteeTypeRequest GUARANTEE_TYPE_REQUEST = new GuaranteeTypeRequest(DOMAIN_GUARANTEE, DESCRIPTION, true, GUARANTEE_TYPE_SUB_LIST);
}
