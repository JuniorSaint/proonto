package br.com.proonto.repositories;

import br.com.proonto.models.entities.Presenter;
import br.com.proonto.models.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {
    @Query(value = "select c from Sender c where c.CONTRATO.id = :id_contract")
    Optional<Sender> findByIdAndContract(@Param("id_contract") Long id_contract);
}
