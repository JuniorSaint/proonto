package br.com.proonto.models.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","agency", "count", "active",  "bank","contact", "creditor"})
public class AgencyBankResponseId extends AgencyBankResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
