package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Daje;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class DajesRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private List<DajeRequest> DAJES;
    private ContractRequest CONTRATO;
}
