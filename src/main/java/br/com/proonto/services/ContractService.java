package br.com.proonto.services;

import br.com.proonto.configs.CP;
import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.CPR;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.requests.*;
import br.com.proonto.models.responses.*;
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


    @Transactional(readOnly = true)
    public ContractResponseId findById(Long id) {
        Optional<Contract> contract = repository.findById(id);
        if (contract.isEmpty()) {
            throw new EntityNotFoundException("contract" + NOT_FOUND + " id: " + id);
        }
        return mapper.map(contract.get(), ContractResponseId.class);
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
