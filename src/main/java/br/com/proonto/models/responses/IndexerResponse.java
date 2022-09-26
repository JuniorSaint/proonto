package br.com.proonto.models.responses;

import br.com.proonto.models.entities.IndexerSub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class IndexerResponse {

    private String domain;
    private String description;
    private Boolean active;
    private List<IndexerSub> indexerSubs;
}

