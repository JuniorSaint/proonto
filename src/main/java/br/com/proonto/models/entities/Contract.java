package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@Table(name = "contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "contract_registryoffice",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "registryoffice_id"))
    private List<RegistryOffice> CARTORIOS;
    private String NUMEROCONTRATO;
    private String TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;
    private String VENCIMENTOPOREXTENSO;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "remetente_id", referencedColumnName = "id")
    private PresenterRepresentative REMETENTE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apresentante_id", referencedColumnName = "id")
    private PresenterRepresentative APRESENTANTE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "financeiro_id", referencedColumnName = "id")
    private Financial FINANCEIRO;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModalityOfOperation> MODALIDADESOPERACAO;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Part> PARTES;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpr_id", referencedColumnName = "id")
    private CPR CPR;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guarantee> GARANTIAS;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Daje> IMPOSTOS;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LetterOfAttorney> PROCURACOES;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorization_id", referencedColumnName = "id")
    private AuthorizationList AUTORIZACOES;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clause> CLAUSULASADICIONAIS;

    @ManyToOne
    @JoinColumn(name="contratos_id")
    private Contracts CONTRATO;
}
