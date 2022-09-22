package br.com.proonto.mocks;

import br.com.proonto.models.entities.GuaranteeType;
import br.com.proonto.models.entities.GuaranteeTypeSub;
import br.com.proonto.models.requests.GuaranteeTypeSubRequest;
import static br.com.proonto.mocks.MessageMock.ID_STRING;

public interface GuaranteeTypeSubMock {
    public static final String SUB = "01";
    public static final String DESCRIPTION_GUARANTEE_SUB = "cheques";

    public static final GuaranteeTypeSub GUARANTEE_TYPE_SUB = new GuaranteeTypeSub();
    public static final GuaranteeTypeSubRequest GUARANTEE_TYPE_SUB_REQUEST = new GuaranteeTypeSubRequest(ID_STRING, SUB, DESCRIPTION_GUARANTEE_SUB, true, new GuaranteeType());
}
