package br.com.proonto.repositories;

import br.com.proonto.models.entities.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTypeRepository extends JpaRepository<LocationType, String> {
}
