package br.com.proonto.repositories;

import br.com.proonto.models.entities.StatesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesTableRepository extends JpaRepository<StatesTable, String> {
}
