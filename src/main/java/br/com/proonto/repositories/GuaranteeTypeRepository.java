package br.com.proonto.repositories;

import br.com.proonto.models.entities.GuaranteeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuaranteeTypeRepository extends JpaRepository<GuaranteeType, String> {
}
