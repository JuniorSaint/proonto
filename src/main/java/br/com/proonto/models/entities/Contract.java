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

    @OneToMany(mappedBy="CONTRATO")
    private List<RegistryOffice> CARTORIOS;

    private String NUMEROCONTRATO;
    private String TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;

    @OneToOne()
    @JoinColumn(name = "remetente_id", referencedColumnName = "id")
    private PresenterRepresentative REMETENTE;

    @OneToOne()
    @JoinColumn(name = "apresentante_id", referencedColumnName = "id")
    private PresenterRepresentative APRESENTANTE;

    @OneToOne()
    @JoinColumn(name = "financeiro_id", referencedColumnName = "id")
    private Financial FINANCEIRO;

    @OneToOne()
    @JoinColumn(name = "modalidade_id", referencedColumnName = "id")
    private ModalityOfOperation MODALIDADESOPERACAO;

    @OneToMany(mappedBy="CONTRATO")
    private List<Part> PARTES;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpr_id", referencedColumnName = "id")
    private CPR CPR;

    @OneToMany(mappedBy="CONTRATO")
    private List<Guarantee> GARANTIAS;

    @OneToMany(mappedBy="CONTRATO")
    private List<Dajes> IMPOSTOS;

    @OneToMany(mappedBy="CONTRATO")
    private List<LetterOfAttorney> PROCURACOES;

    @OneToMany(mappedBy="CONTRATO")
    private List<Authorization> AUTORIZACOES;

    @OneToMany(mappedBy="CONTRATO")
    private List<Clause> CLAUSULASADICIONAIS;
}
