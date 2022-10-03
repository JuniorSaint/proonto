package br.com.proonto.models.requests;

import lombok.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String fromDic;
    private String toDic;
    private Boolean active;
}