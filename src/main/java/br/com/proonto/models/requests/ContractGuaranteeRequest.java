package br.com.proonto.models.requests;

import br.com.proonto.models.entities.BallotType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ContractGuaranteeRequest extends ContractFirstRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<GuaranteeRequest> GARANTIAS;
}
