package br.com.proonto.models.requests;

import br.com.proonto.models.entities.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ContractRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private List<RegistryOfficeRequest> CARTORIOS;
    private String NUMEROCONTRATO;
    private String TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;
    private String VENCIMENTOPOREXTENSO;
    private PresenterRepresentativeRequest REMETENTE;
    private PresenterRepresentativeRequest APRESENTANTE;
    private FinancialRequest FINANCEIRO;
    private List<ModalityOfOperationRequest> MODALIDADESOPERACAO;
    private List<PartRequest> PARTES;
    private CPRRequest CPR;
    private List<GuaranteeRequest> GARANTIAS;
    private List<DajeRequest> IMPOSTOS;
    private List<LetterOfAttorneyRequest> PROCURACOES;
    private AuthorizationRequest AUTORIZACOES;
    private List<ClauseRequest> CLAUSULASADICIONAIS;
}
