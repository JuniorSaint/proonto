package br.com.proonto.repositories;

import br.com.proonto.models.entities.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepositoy extends JpaRepository<Authorization, Long> {
}
