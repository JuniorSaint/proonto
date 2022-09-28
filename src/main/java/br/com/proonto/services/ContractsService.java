package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Contracts;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.ContractsRequest;
import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.models.responses.ContractsResponse;
import br.com.proonto.repositories.ContractRepository;
import br.com.proonto.repositories.ContractsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class ContractsService {
    @Autowired
    private ContractsRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private Utils utils;


    @Transactional
    public ContractsResponse saveUpdate(ContractsRequest request) {
        if (request.getId() != null) {
            ContractsResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contracts.class)), ContractsResponse.class);
    }

    @Transactional(readOnly = true)
    public ContractsResponse findById(Long id) {
        Optional<Contracts> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Contracts" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, ContractsResponse.class);
    }
    @Transactional
    public String delete(Long id) {
        try {
            repository.deleteById(id);
            return "Contracts" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Object is linked, deleting is not allowed.");
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Contracts" + NOT_FOUND + "id: " + id);
        }
    }
}
