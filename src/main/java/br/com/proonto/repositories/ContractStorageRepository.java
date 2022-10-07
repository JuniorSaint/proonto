package br.com.proonto.repositories;

import br.com.proonto.models.entities.ContractStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractStorageRepository extends JpaRepository<ContractStorage, Long> {
}
