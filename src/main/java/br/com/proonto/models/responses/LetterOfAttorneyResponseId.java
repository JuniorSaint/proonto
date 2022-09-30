package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class LetterOfAttorneyResponseId extends LetterOfAttorneyResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
