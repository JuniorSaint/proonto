package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Parameter;
import br.com.proonto.models.entities.Template;
import br.com.proonto.models.enums.CreditorTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CreditorMatrixResponseForBranch implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}