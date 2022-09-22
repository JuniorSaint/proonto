package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.controllers.ImmovableController;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Immovable;
import br.com.proonto.models.requests.ImmovableRequest;
import br.com.proonto.repositories.AddressRespository;
import br.com.proonto.repositories.ImmovableRepository;
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
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ImmovableService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ImmovableRepository repository;
    @Autowired
    private Utils utils;
    @Autowired
    private AddressRespository addressRespository;

    Immovable immovable = new Immovable();

    @Transactional
    public Immovable saveUpdate(ImmovableRequest immovableRequestPost) {
//        mapper.map(immovableRequestPost, immovable);
//        immovable.setCpf(immovable.getCpf().replaceAll("\\D", ""));
//        if (immovable.getId() != null) {
//            Immovable resp = findById(immovable.getId());
//        }
//        immovable.setAddress(addressRespository.save(immovable.getAddress()));
//        Immovable response = repository.save(immovable);
//        return response;
        return null;
    }

    @Transactional(readOnly = true)
    public Immovable findById(Long id) {
        Optional<Immovable> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Immovable" + NOT_FOUND + "id: "+ id);
        }
        return response.get();
    }

    @Transactional(readOnly = true)
    public List<Immovable> findAll() {
        return repository.findAll();
    }

    @Transactional
    public String delete(Long id) {
        try {
            Immovable response = findById(id);
            repository.delete(response);
            return "Immovable" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
