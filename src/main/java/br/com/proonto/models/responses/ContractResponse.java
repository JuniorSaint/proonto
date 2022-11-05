package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<RegistryOfficeResponseId> CARTORIOS;
    private String NUMEROCONTRATO;
    private BallotTypeResponse TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;
    private SenderResponseId REMETENTE;
    private PresenterResponseId APRESENTANTE;
    private FinancialResponseId FINANCEIRO;
    private List<ModalityOfOperationResponse> MODALIDADESOPERACAO;
    private List<PartResponseId> PARTES;
    private CPRResponseId CPR;
    private List<GuaranteeResponseId> GARANTIAS;
    private List<DajeResponseId> IMPOSTOS;
    private List<LetterOfAttorneyResponseId> PROCURACOES;
    private AuthorizationResponseId AUTORIZACOES;
    private List<ClauseResponseId> CLAUSULASADICIONAIS;
}
