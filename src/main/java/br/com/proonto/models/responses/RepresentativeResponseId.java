package br.com.proonto.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RepresentativeResponseId extends RepresentativeResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
