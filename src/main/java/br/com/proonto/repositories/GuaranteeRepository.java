package br.com.proonto.repositories;

import br.com.proonto.models.entities.CPR;
import br.com.proonto.models.entities.Guarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuaranteeRepository extends JpaRepository<Guarantee, Long> {

}
