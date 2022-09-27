package br.com.proonto.models.requests;

import br.com.proonto.models.entities.ModalityOfTheOperationSub;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModalityOfTheOperationRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String domain;
    private String description;
    private Boolean active;
    private List<ModalityOfTheOperationSub> modalityOfTheOperationSubs;
}

