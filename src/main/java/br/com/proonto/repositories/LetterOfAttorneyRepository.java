package br.com.proonto.repositories;

import br.com.proonto.models.entities.LetterOfAttorney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterOfAttorneyRepository extends JpaRepository<LetterOfAttorney, Long> {
}
