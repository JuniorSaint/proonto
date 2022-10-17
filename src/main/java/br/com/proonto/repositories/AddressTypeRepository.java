package br.com.proonto.repositories;

import br.com.proonto.models.entities.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, String> {
}
