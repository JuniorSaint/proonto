package br.com.proonto.models.entities;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "agencyBank")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AgencyBank implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agency;
    private String count;
    private boolean active;
    @OneToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name="creditor_id")
    private Creditor creditor;
}