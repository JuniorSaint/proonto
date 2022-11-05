package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "contacts")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NOME;
    private String TELEFONE;
    private String EMAIL;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public void setTELEFONE(String TELEFONE) {
        if(TELEFONE == null){
            this.TELEFONE = TELEFONE;
        }else{
        this.TELEFONE = TELEFONE.replaceAll("\\D", "");
        }
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}