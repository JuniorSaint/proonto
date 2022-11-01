package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.PartsRole;
import br.com.proonto.repositories.PartsRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class PartsRoleService {
    @Autowired
    private PartsRoleRepository repository;

    @Transactional(readOnly = true)
    public PartsRole findById(String id) {
        Optional<PartsRole> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Part's role" + NOT_FOUND + "id: " + id);
        }
        return response.get();
    }
}
