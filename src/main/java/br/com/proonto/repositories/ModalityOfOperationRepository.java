package br.com.proonto.repositories;

import br.com.proonto.models.entities.ModalityOfOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityOfOperationRepository extends JpaRepository<ModalityOfOperation, Long> {
}
