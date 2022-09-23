package br.com.proonto.repositories;

import br.com.proonto.models.entities.LocationProdution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationProductionRepository extends JpaRepository<LocationProdution, Long> {
}
