package br.com.proonto.models.requests;

import br.com.proonto.models.entities.IndexerSub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class IndexerRequest {

    private String domain;
    private String description;
    private Boolean active;
    private List<IndexerSub> indexerSubs;
}

