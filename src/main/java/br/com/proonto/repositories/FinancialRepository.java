package br.com.proonto.repositories;

import br.com.proonto.models.entities.Financial;
import br.com.proonto.models.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FinancialRepository extends JpaRepository<Financial, Long> {
}
