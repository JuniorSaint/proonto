package br.com.proonto.models.responses;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fromDic;
    private String toDic;
    private Boolean active;
}