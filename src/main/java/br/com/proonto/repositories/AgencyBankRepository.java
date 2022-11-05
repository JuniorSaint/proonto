package br.com.proonto.repositories;

import br.com.proonto.models.entities.AgencyBank;
import br.com.proonto.models.responses.AgencyBankResponseTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyBankRepository extends JpaRepository<AgencyBank, Long> {
//    @Query(value = "SELECT a FROM AgencyBank a WHERE a.count = :count")
    AgencyBankResponseTest findByCount(String count);
}
