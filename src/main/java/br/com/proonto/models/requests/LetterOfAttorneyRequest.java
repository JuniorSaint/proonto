package br.com.proonto.models.requests;

import br.com.proonto.models.entities.RecordTypesTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class LetterOfAttorneyRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String REPRESENTANTE;
    private String REPRESENTADO;
    private String NUMERO;
    private RecordTypesTableRequest TIPOREGISTRO;
    private String ORGAO;
    private String FORMAREGISTRO;
    private String NUMEROLIVRO;
    private String FOLHA;
    private String NUMEROREGISTRO;
    private LocalDate DATAREGISTRO;
}
