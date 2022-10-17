package br.com.proonto.services;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.LocationType;
import br.com.proonto.models.requests.LocationTypeRequest;
import br.com.proonto.models.responses.LocationTypeResponse;
import br.com.proonto.repositories.LocationTypeRepository;

@Service
public class LocationTypeService {
    @Autowired
    private LocationTypeRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public LocationTypeResponse saveUpdate(LocationTypeRequest request) {
        if (request.getDomain() != null) {
            LocationTypeResponse responseBank = findById(request.getDomain());
        }
        return mapper.map(repository.save(mapper.map(request, LocationType.class)), LocationTypeResponse.class);
    }

    @Transactional(readOnly = true)
    public LocationTypeResponse findById(String id) {
        Optional<LocationType> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Location type" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), LocationTypeResponse.class);
    }

    @Transactional(readOnly = true)
    public List<LocationTypeResponse> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), LocationTypeResponse.class);
    }

    @Transactional
    public String delete(String id) {
        try {
            LocationTypeResponse response = findById(id);
            repository.deleteById(id);
            return "Location type" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
