package br.com.proonto.models.responses;

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
public class SenderResponse extends PresenterResponse implements Serializable {
    private static final long serialVersionUID = 1L;
}
