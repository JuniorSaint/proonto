package br.com.proonto.repositories;

import br.com.proonto.models.entities.GuaranteeTypeSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuaranteeTypeSubRepository extends JpaRepository<GuaranteeTypeSub, String> {
}
