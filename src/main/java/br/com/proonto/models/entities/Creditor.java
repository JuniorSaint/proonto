package br.com.proonto.models.entities;

import br.com.proonto.models.enums.CreditorTypeEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue("creditor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Creditor extends Part implements Serializable {
    private static final long serialVersionUID = 1L;

    private CreditorTypeEnum typeFiliation;
    @OneToOne
    @JoinColumn(name = "parameter_id", referencedColumnName = "id")
    private Parameter parameter;

    @OneToMany(mappedBy="creditor")
    private List<User> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "matrix_id", referencedColumnName = "id")
    private Creditor branch;

    @OneToOne
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    private Template template;
}