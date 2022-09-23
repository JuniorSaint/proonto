package br.com.proonto.repositories;

import br.com.proonto.models.entities.FilesArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<FilesArea, Long> {
}
