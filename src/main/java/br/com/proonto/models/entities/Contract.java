package br.com.proonto.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(
            name = "contract_registryoffice",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "registryoffice_id")
            )
    private Set<RegistryOffice> CARTORIOS;
    private String NUMEROCONTRATO;
    @OneToOne
    @JoinColumn(name = "tipo_cedula_id", referencedColumnName = "domain")
    private BallotType TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ModalityOfOperation> MODALIDADESOPERACAO;

    @OneToMany
    private List<Part> PARTES;

    @OneToOne(mappedBy = "CONTRATO", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CPR CPR;

    @OneToMany
    private Set<Guarantee> GARANTIAS;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Daje> IMPOSTOS;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LetterOfAttorney> PROCURACOES;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorization_id", referencedColumnName = "id")
    private AuthorizationList AUTORIZACOES;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Clause> CLAUSULASADICIONAIS;

    @ManyToOne
    @JoinColumn(name = "contratos_id")
    private Contracts CONTRATO;

    @OneToOne
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    private Template template;

    //Doesn't belong the original xml, these variable it's to complete the form
    private String VENCIMENTOPOREXTENSO;
    private LocalDate VENCIMENTO;
    private LocalDate COBRANCAENCARGOAPARTIR;
    private String TITULODOCABECALHO;
    private String CIDADEESTADODATACONTRATO;
    private String UMIDADE;
    private String IMPUREZA;
    private String AVARIADOS_ARDIDOS;
}
