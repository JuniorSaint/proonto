package br.com.proonto.repositories;

import br.com.proonto.models.entities.RegistryOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistryOfficeRepository extends JpaRepository<RegistryOffice, Long> {

    Optional<RegistryOffice> findByCNS(String cns);

    @Query("SELECT r FROM RegistryOffice r WHERE r.CNS IN :inclList ")
    List<RegistryOffice> findListRegistryInclude(@Param("inclList") List<String> inclList);

}
