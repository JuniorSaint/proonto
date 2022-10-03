package br.com.proonto.models.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "addressType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class AddressType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String code;
    private String abbreviation;
    private String street;
    private Boolean active;
}

