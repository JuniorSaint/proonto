package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;
import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","nome", "tipopessoa", "cpfcnpj",  "parameter","endereco", "users", "contato", "agencyBanks"})
public class CreditorBranchResponseId extends CreditorBranchResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}