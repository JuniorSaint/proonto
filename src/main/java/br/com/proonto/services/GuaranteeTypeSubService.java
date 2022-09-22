package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.GuaranteeType;
import br.com.proonto.models.entities.GuaranteeTypeSub;
import br.com.proonto.models.requests.GuaranteeTypeSubRequest;
import br.com.proonto.repositories.GuaranteeTypeSubRepository;
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
public class GuaranteeTypeSubService {
    @Autowired
    private GuaranteeTypeSubRepository repository;
    @Autowired
    private GuaranteeTypeService guaranteeTypeService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    GuaranteeTypeSub guaranteeTypeSub = new GuaranteeTypeSub();

    @Transactional
    public GuaranteeTypeSub saveUpdate(GuaranteeTypeSubRequest guaranteeTypeSubRequest) {
        if (guaranteeTypeSubRequest.getId() != null) {
            GuaranteeTypeSub response = findById(guaranteeTypeSubRequest.getId());
        }
        mapper.map(guaranteeTypeSubRequest, guaranteeTypeSub);
        guaranteeTypeSub.setGuaranteeType(guaranteeTypeService.findById(guaranteeTypeSubRequest.getGuaranteeType().getDomain()));
        return repository.save(guaranteeTypeSub);
    }

    public GuaranteeTypeSub findById(String id) {
        Optional<GuaranteeTypeSub> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Guarantee type sub" + NOT_FOUND + "id: " + id);
        }
        return response.get();
    }

    @Transactional(readOnly = true)
    public List<GuaranteeTypeSub> findAll() {
        return repository.findAll();
    }

    @Transactional
    public String delete(String id) {
        try {
            GuaranteeTypeSub response = findById(id);
            repository.delete(response);
            return "Guarantee type sub" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
