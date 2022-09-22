package br.com.proonto.repositories;

import br.com.proonto.models.entities.PartsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRoleRepository extends JpaRepository<PartsRole, String> {
}
