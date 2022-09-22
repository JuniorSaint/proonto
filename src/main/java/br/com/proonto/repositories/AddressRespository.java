package br.com.proonto.repositories;

import br.com.proonto.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRespository extends JpaRepository<Address, Long> {
}
