package br.com.proonto.repositories;

import br.com.proonto.models.entities.Immovable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmovableRepository extends JpaRepository<Immovable, Long> {
}
