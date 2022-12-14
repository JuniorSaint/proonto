package br.com.proonto.repositories;

import br.com.proonto.models.entities.Pact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PactRepository extends JpaRepository<Pact, Long> {
}
