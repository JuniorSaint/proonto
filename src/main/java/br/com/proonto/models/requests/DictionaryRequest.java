package br.com.proonto.models.requests;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private Boolean active;
}