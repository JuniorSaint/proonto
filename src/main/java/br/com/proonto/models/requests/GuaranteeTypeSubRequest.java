package br.com.proonto.models.requests;


import br.com.proonto.models.entities.GuaranteeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class GuaranteeTypeSubRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String sub;
    private String description;
    private Boolean active;
    private GuaranteeType guaranteeType;
}