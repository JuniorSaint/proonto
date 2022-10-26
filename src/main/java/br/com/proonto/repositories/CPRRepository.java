package br.com.proonto.repositories;

import br.com.proonto.models.entities.CPR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CPRRepository extends JpaRepository<CPR, Long> {

    @Query(value = "select c from CPR c where c.CONTRATO.id = :id_contract")
    Optional<CPR> findByIdAndContract(@Param("id_contract") Long id_contract);
}
