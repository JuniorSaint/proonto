package br.com.proonto.models.responses;

import br.com.proonto.models.entities.BallotType;
import br.com.proonto.models.requests.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "numerocontrato", "tipocedula", "datacontrato", "localcontrato", "cartorios", "modalidadesoperacao", "procuracoes", "autorizacoes",
        "clausulasadicionais", "vencimentoporextenso", "vencimento", "cobrancaencargoapartir", "titulodocabecalho", "cidadeestadodatacontrato", "umidade", "impureza",
"avariados_ardidos"})
public class ContractFirstResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private List<RegistryOfficeRequest> CARTORIOS;
    private String NUMEROCONTRATO;
    private BallotTypeRequest TIPOCEDULA;
    private LocalDate DATACONTRATO;
    private String LOCALCONTRATO;
    private List<ModalityOfOperationRequest> MODALIDADESOPERACAO;
    private List<LetterOfAttorneyRequest> PROCURACOES;
    private AuthorizationRequest AUTORIZACOES;
    private List<ClauseRequest> CLAUSULASADICIONAIS;

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
