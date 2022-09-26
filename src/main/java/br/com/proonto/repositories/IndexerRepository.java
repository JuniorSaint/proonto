package br.com.proonto.repositories;

import br.com.proonto.models.entities.Indexer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexerRepository extends JpaRepository<Indexer, String> {
}
