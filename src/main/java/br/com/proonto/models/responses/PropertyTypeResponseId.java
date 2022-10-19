package br.com.proonto.models.responses;

import br.com.proonto.models.entities.Guarantee;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyTypeResponseId  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String domain;
}
