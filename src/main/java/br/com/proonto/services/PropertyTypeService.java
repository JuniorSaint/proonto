package br.com.proonto.services;

import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.PropertyType;
import br.com.proonto.models.requests.PropertyTypeRequest;
import br.com.proonto.repositories.PropertyTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class PropertyTypeService {
    @Autowired
    private PropertyTypeRepository repository;
    @Autowired
    private ModelMapper mapper;
    PropertyType propertyType = new PropertyType();

    @Transactional
    public PropertyType saveUpdate(PropertyTypeRequest propertyTypeRequest) {
        if (propertyTypeRequest.getDomain() != null) {
            PropertyType responseProperty = findById(propertyTypeRequest.getDomain());
        }
        mapper.map(propertyTypeRequest, propertyType);
        PropertyType response = repository.save(propertyType);
        return response;
    }

    @Transactional(readOnly = true)
    public PropertyType findById(String id) {
        Optional<PropertyType> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Property type" + NOT_FOUND + "id: " + id);
        }
        return response.get();
    }

    @Transactional(readOnly = true)
    public List<PropertyType> findAll() {
        List<PropertyType> response = repository.findAll();
        return response;
    }

    @Transactional
    public String delete(String id) {
        try {
            PropertyType response = findById(id);
            repository.delete(response);
            return "Property type" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
