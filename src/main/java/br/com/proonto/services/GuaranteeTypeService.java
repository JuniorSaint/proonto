package br.com.proonto.services;

import br.com.proonto.controllers.GuaranteeTypeController;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.GuaranteeType;
import br.com.proonto.models.requests.GuaranteeTypeRequest;
import br.com.proonto.repositories.GuaranteeTypeRepository;
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
public class GuaranteeTypeService {
    @Autowired
    private GuaranteeTypeRepository repository;
    @Autowired
    private ModelMapper mapper;
    GuaranteeType guaranteeType = new GuaranteeType();

    @Transactional
    public GuaranteeType saveUpdate(GuaranteeTypeRequest guaranteeTypeRequest) {
        if (guaranteeTypeRequest.getDomain() != (null)) {
            GuaranteeType responseGuarantee = findById(guaranteeTypeRequest.getDomain());
        }
        mapper.map(guaranteeTypeRequest, guaranteeType);
        GuaranteeType response = repository.save(guaranteeType);
        return response;
    }

    @Transactional(readOnly = true)
    public GuaranteeType findById(String id) {
        Optional<GuaranteeType> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Guarantee type " + NOT_FOUND + id);
        }
        return response.get();
    }

    @Transactional(readOnly = true)
    public List<GuaranteeType> findAll() {
        return repository.findAll();
    }

    @Transactional
    public String delete(String id) {
        try {
            GuaranteeType response = findById(id);
            repository.delete(response);
            return "Guarantee type" +DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
