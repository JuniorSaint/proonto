package br.com.proonto.models.requests;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartsRoleRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String domain;
}