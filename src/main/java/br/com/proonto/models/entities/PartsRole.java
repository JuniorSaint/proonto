package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "partsRole")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class PartsRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String domain;
    private String description;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="part_id")
    private Part part;
}