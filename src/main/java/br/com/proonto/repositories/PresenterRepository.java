package br.com.proonto.repositories;

import br.com.proonto.models.entities.Guarantee;
import br.com.proonto.models.entities.Presenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PresenterRepository extends JpaRepository<Presenter, Long> {

    @Query(value = "select c from Presenter c where c.CONTRATO.id = :id_contract")
    Optional<Presenter> findByIdAndContract(@Param("id_contract") Long id_contract);
}
