package br.com.proonto.repositories;

import br.com.proonto.models.entities.MainContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsRepository extends JpaRepository<MainContract, Long> {
}
