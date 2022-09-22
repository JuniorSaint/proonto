package br.com.proonto.models.responses;

import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.DajeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class DajesResponse {
    private List<DajeResponse> DAJES;
}
