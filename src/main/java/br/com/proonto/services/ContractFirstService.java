package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.RegistryOffice;
import br.com.proonto.models.requests.*;
import br.com.proonto.models.responses.*;
import br.com.proonto.repositories.ContractRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class ContractFirstService {
    @Autowired
    private ContractRepository repository;
    @Autowired
    private RegistryOfficeService registryOfficeService;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private Utils utils;

    @Transactional
    public ContractFirstResponse saveFirst(ContractFirstRequest request) {
        Set<RegistryOffice> resultToInset = new HashSet<>();
        if (!request.getCARTORIOS().isEmpty()) {
            resultToInset = registryOfficeService.verifyIncludeAndSave(request.getCARTORIOS());

        }
        Contract contractTocheck = mapper.map(request, Contract.class);
        contractTocheck.setCARTORIOS(resultToInset);
        return mapper.map(repository.save(contractTocheck), ContractFirstResponse.class);
    }

    @Transactional(readOnly = true)
    public ContractFirstResponse findById(Long id) {
        Optional<Contract> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Contract First" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, ContractFirstResponse.class);
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
