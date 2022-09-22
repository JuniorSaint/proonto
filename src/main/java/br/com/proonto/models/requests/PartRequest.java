package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Qualification;
import br.com.proonto.models.enums.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class PartRequest {
    private Long id;
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
    private AddressRequest ENDERECO;
    private List<QualificationRequest> QUALIFICACOES;
    private ContactRequest CONTATO;
    private ContractRequest CONTRATO;
}
