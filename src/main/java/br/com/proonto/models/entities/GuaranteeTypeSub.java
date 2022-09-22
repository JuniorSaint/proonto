package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "guaranteeTypeSub")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class GuaranteeTypeSub  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String sub;
    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "guaranteeType_id")
    private GuaranteeType guaranteeType;
}