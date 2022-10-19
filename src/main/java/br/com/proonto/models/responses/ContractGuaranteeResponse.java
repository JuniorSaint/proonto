package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContractGuaranteeResponse extends ContractFirstResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<GuaranteeResponseId> GARANTIAS;
}
