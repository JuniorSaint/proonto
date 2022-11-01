package br.com.proonto.services;

import static br.com.proonto.configs.CP.NOT_FOUND;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Registry;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.requests.RegistryRequest;
import br.com.proonto.models.responses.RegistryResponse;
import br.com.proonto.repositories.RegistryRepository;

@Service
public class RegistryService {
    @Autowired
    private RegistryRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ImmovableService immovableService;
    @Autowired
    private Utils utils;

    @Transactional
    public RegistryRequest saveUpdate(RegistryRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        request.setIMOVEL(immovableService.saveUpdate(mapper.map(request.getIMOVEL(), ImmovableRequest.class)));
        return mapper.map(repository.save(mapper.map(request, Registry.class)), RegistryRequest.class);
    }

    @Transactional(readOnly = true)
    public RegistryResponse findById(Long id) {
        Optional<Registry> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Registry" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), RegistryResponse.class);
    }
}
