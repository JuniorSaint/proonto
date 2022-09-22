package br.com.proonto.repositories;

import br.com.proonto.models.entities.Daje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DajeRepository extends JpaRepository<Daje, Long> {
}
