package br.com.proonto.models.responses;

import br.com.proonto.models.entities.IndexerSub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class IndexerResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String domain;
    private String description;
    private Boolean active;
    private List<IndexerSub> indexerSubs;
}

