package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModalityOfTheOperationSubResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
}