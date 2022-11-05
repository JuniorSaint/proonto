package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseId extends ContactResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
