package br.com.proonto.models.requests;

import br.com.proonto.models.entities.AgencyBank;
import br.com.proonto.models.entities.PresenterRepresentative;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private Long id;
    private String NOME;
    private String TELEFONE;
    private String EMAIL;
}
