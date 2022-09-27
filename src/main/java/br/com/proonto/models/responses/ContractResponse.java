package br.com.proonto.models.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ContractResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private List<RegistryOfficeResponseId> CARTORIOS;
    private String NUMEROCONTRATO;
    private String TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;
    private PresenterRepresentativeResponseId REMETENTE;
    private PresenterRepresentativeResponseId APRESENTANTE;
    private FinancialResponseId FINANCEIRO;
    private List<ModalityOfOperationResponseId> MODALIDADESOPERACAO;
    private List<PartResponseId> PARTES;
    private CPRResponseId CPR;
    private List<GuaranteeResponseId> GARANTIAS;
    private List<DajeResponseId> IMPOSTOS;
    private List<LetterOfAttorneyResponseId> PROCURACOES;
    private AuthorizationResponseId AUTORIZACOES;
    private List<ClauseResponseId> CLAUSULASADICIONAIS;
}
