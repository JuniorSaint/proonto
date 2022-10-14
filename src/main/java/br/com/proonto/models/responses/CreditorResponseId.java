package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.entities.Parameter;
import br.com.proonto.models.enums.CreditorTypeEnum;
import br.com.proonto.models.requests.ContactRequest;
import br.com.proonto.models.requests.QualificationRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreditorResponseId extends CreditorResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}