package br.com.proonto.repositories;

import br.com.proonto.models.entities.AgencyBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyBankRepository extends JpaRepository<AgencyBank, Long> {
}
