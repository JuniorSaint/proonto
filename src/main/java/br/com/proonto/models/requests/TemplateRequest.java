package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.responses.CreditorMatrixResponse;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TemplateRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String body;
    private CreditorMatrixRequest creditor;
}