package br.com.proonto.models.responses;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponseId extends ContractResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

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
