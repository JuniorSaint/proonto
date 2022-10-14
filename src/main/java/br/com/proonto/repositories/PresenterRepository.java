package br.com.proonto.repositories;

import br.com.proonto.models.entities.Presenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenterRepository extends JpaRepository<Presenter, Long> {
}
