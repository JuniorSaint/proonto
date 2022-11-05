package br.com.proonto.models.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "registriesOffices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistryOffice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String CNS;
    private String NOME;
    private String COMARCA;
    private String UF;
}
