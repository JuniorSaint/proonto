package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Financial;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CPRResponseId extends CPRResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
