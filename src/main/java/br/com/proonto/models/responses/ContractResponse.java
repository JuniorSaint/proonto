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
    private List<RegistryOfficeResponse> CARTORIOS;
    private String NUMEROCONTRATO;
    private String TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;
    private PresenterRepresentativeResponse REMETENTE;
    private PresenterRepresentativeResponse APRESENTANTE;
    private FinancialResponse FINANCEIRO;
    private ModalityOfOperationResponse MODALIDADESOPERACAO;
    private List<PartResponse> PARTES;
    private CPRResponse CPR;
    private List<GuaranteeResponse> GARANTIAS;
    private List<DajeResponse> IMPOSTOS;
    private List<LetterOfAttorneyResponse> PROCURACOES;
    private List<AuthorizationResponse> AUTORIZACOES;
    private List<ClauseResponse> CLAUSULASADICIONAIS;
}
