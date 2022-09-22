package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "bank")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Bank extends RepresentationModel<Bank> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String ispb;
    private String cnpj;
    private String nameBank;
    private String url;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToOne(mappedBy = "bank")
    private AgencyBank AGENCYBANK;

    public Bank(Long id, String code, String ispb, String cnpj, String nameBank, String url, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.code = code;
        this.ispb = ispb;
        this.cnpj = cnpj;
        this.nameBank = nameBank;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}