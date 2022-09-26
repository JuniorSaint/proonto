package br.com.proonto.repositories;

import br.com.proonto.models.entities.ModalityOfTheOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityOfTheOperationRepository extends JpaRepository<ModalityOfTheOperation, String> {
}
