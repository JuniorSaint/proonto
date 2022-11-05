package br.com.proonto.models.responses;

import br.com.proonto.models.entities.ModalityOfTheOperationSub;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModalityOfTheOperationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String domain;
    private String description;
    private Boolean active;
    private List<ModalityOfTheOperationSub> modalityOfTheOperationSubs;
}

