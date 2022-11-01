package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.requests.AddressRequest;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.models.responses.ImmovableResponseId;
import br.com.proonto.repositories.ImmovableRepository;
import br.com.proonto.repositories.LocationTypeRepository;
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
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class ImmovableService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ImmovableRepository repository;
    @Autowired
    private Utils utils;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;
    @Autowired
    private LocationTypeRepository locationTypeRepository;

    Immovable immovable = new Immovable();

    @Transactional
    public ImmovableRequest saveUpdate(ImmovableRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        mapper.map(request, immovable);
        immovable.setENDERECO(addressService.saveUpdate(mapper.map(request.getENDERECO(), AddressRequest.class)));
        immovable.setTIPOIMOVEL(propertyTypeRepository.findById(request.getTIPOIMOVEL().getDomain()).get());
        immovable.setTIPOLOCALIZACAO(locationTypeRepository.findById(request.getTIPOLOCALIZACAO().getDomain()).get());
        return mapper.map(repository.save(immovable), ImmovableRequest.class);
    }

    @Transactional(readOnly = true)
    public ImmovableResponseId findById(Long id) {
        Optional<Immovable> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Immovable" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), ImmovableResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<ImmovableResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), ImmovableResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Immovable" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
