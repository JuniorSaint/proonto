package br.com.proonto.repositories;

import br.com.proonto.models.entities.Creditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditorRepository extends JpaRepository<Creditor, Long> {
}
