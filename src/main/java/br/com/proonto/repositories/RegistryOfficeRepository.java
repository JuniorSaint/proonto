package br.com.proonto.repositories;

import br.com.proonto.models.entities.RegistryOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryOfficeRepository extends JpaRepository<RegistryOffice, Long> {
}
