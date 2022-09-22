package br.com.proonto.models.responses;

import br.com.proonto.models.enums.GenderType;
import br.com.proonto.models.requests.AddressRequest;
import br.com.proonto.models.requests.ContactRequest;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.QualificationRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class PartResponse {
    private String NOME;
    private String TIPOPESSOA;
    private String CPFCNPJ;
    private GenderType GENERO;
    private LocalDate DATANASCIMENTO;
    private String DOCUMENTO;
    private String ORGAOEMISSOR;
    private String NACIONALIDADE;
    private String ESTADOCIVIL;
    private String PACTO;
    private String REGIMEBENS;
    private String PROFISSAO;
    private String FILIACAO1;
    private String FILIACAO2;
    private String CPFCONJUGE;
    private AddressResponse ENDERECO;
    private List<QualificationResponse> QUALIFICACOES;
    private ContactResponse CONTATO;
}
