package br.com.proonto.services;

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


    @Transactional
    public ContractFirstResponse saveFirst(ContractFirstRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractFirstResponse.class);
    }

    @Transactional
    public ContractGuaranteeResponse saveGuarantee(ContractGuaranteeRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractGuaranteeResponse.class);
    }

    @Transactional
    public ContractPartsResponse saveParts(ContractPartsRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractPartsResponse.class);
    }

    @Transactional
    public ContractPresenterSenderResponse savePresenter(ContractPresenterSenderRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractPresenterSenderResponse.class);
    }

    @Transactional
    public ContractCprResponse saveCpr(ContractCprRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractCprResponse.class);
    }

    @Transactional
    public ContractFinancialResponse saveFinancial(ContractFinancialRequest request) {
        if (request.getId() != null) {
            ContractResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Contract.class)), ContractFinancialResponse.class);
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
