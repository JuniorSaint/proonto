package br.com.proonto.repositories;

import br.com.proonto.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    @Query(value = "select p from Part p where p.CPFCNPJ = :cnpj")
    Optional<Part> findByCnpjCpf(@Param(value = "cnpj") String cnpj);
}
