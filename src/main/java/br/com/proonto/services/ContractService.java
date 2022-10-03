package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.CPR;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.requests.CPRRequest;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.responses.CPRResponse;
import br.com.proonto.models.responses.ContactResponse;
import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.models.responses.ContractResponseId;
import br.com.proonto.repositories.ContractRepository;
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
public class ContractService {
    @Autowired
    private ContractRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private Utils utils;


    @Transactional
    public ContractResponseId saveUpdate(ContractRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractResponseId.class);
    }

    @Transactional(readOnly = true)
    public ContractResponseId findById(Long id) {
        Optional<Contract> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Contract" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, ContractResponseId.class);
    }
    @Transactional
    public String delete(Long id) {
        try {
            repository.deleteById(id);
            return "Contract" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Object is linked, deleting is not allowed.");
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Contract" + NOT_FOUND + "id: " + id);
        }
    }
}
