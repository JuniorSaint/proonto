package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.LocationProdution;
import br.com.proonto.models.requests.LocationProductionRequest;
import br.com.proonto.repositories.LocationProductionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class LocationProdutionService {
    @Autowired
    private LocationProductionRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public LocationProductionRequest saveUpdate(LocationProductionRequest request) {
        if (request.getId() != null) {
            LocationProductionRequest resp = findById(request.getId());
        }
      LocationProdution tes =   mapper.map(request, LocationProdution.class);
        return mapper.map(repository.save(tes),LocationProductionRequest.class);
    }

    public LocationProductionRequest findById(Long id) {
        Optional<LocationProdution> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Location of prodution" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, LocationProductionRequest.class);
    }
}
