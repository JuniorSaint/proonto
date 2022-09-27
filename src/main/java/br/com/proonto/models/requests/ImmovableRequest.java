package br.com.proonto.models.requests;

import br.com.proonto.models.entities.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class ImmovableRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String EDIFICACAO;
    private String DESCRICAO;
    private String TIPOLOCALIZACAO;
    private String TIPOIMOVEL;
    private AddressRequest ENDERECO;
}
