package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.ContractStorage;
import br.com.proonto.models.requests.ContractStorageRequest;
import br.com.proonto.models.responses.ContractStorageResponse;
import br.com.proonto.repositories.ContractStorageRepository;
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
public class ContractStorageService {
    @Autowired
    private ContractStorageRepository repository;
    @Autowired
    private ContractService serviceContract;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public ContractStorageResponse saveUpdate(ContractStorageRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        ContractStorage response = mapper.map(request, ContractStorage.class);
        return mapper.map(repository.save(response), ContractStorageResponse.class);
    }

    @Transactional(readOnly = true)
    public ContractStorageResponse findById(Long id) {
        Optional<ContractStorage> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Contract Storage" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), ContractStorageResponse.class);
    }

    @Transactional(readOnly = true)
    public List<ContractStorageResponse> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), ContractStorageResponse.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Contract storage" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

}
