package br.com.proonto.repositories;

import br.com.proonto.models.entities.Dajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DajesRepository extends JpaRepository<Dajes, Long> {
}
