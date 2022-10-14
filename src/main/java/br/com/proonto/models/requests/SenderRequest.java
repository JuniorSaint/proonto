package br.com.proonto.models.requests;

import br.com.proonto.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SenderRequest extends PresenterRequest implements Serializable {
    private static final long serialVersionUID = 1L;
}

