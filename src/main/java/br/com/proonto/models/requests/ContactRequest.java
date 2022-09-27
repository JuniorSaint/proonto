package br.com.proonto.models.requests;

import br.com.proonto.models.entities.AgencyBank;
import br.com.proonto.models.entities.PresenterRepresentative;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String NOME;
    private String TELEFONE;
    private String EMAIL;
}
