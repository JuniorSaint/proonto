package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Contract;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractStorageRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String storage;
    private Contract contract;
}