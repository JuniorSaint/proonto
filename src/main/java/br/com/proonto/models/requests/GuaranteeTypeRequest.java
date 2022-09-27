package br.com.proonto.models.requests;

import br.com.proonto.models.entities.GuaranteeTypeSub;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuaranteeTypeRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String domain;
    private String description;
    private Boolean active;
    private List<GuaranteeTypeSub> guaranteeTypeSubs;
}