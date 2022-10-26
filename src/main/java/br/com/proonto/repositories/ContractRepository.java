package br.com.proonto.repositories;

import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Guarantee;
import br.com.proonto.models.entities.RegistryOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "SELECT c FROM Contract c WHERE c.id = :id_contract")
    List<Contract> findByContractAndGuarantes(@Param("id_contract") Long id_contract);
}
