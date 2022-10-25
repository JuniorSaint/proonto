package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.CreditorMatrixRequest;
import br.com.proonto.models.responses.ContractFirstResponse;
import br.com.proonto.models.responses.CreditorMatrixResponseId;
import br.com.proonto.repositories.CreditorRepository;
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
public class CreditorMatrixService {
    @Autowired
    private CreditorRepository repository;
    @Autowired
    private ContractFirstService contractFirstService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    Contact contact = new Contact();

    @Transactional
    public CreditorMatrixResponseId saveUpdate(CreditorMatrixRequest request, Long id_contract) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        request.setCONTRATO(mapper.map(contractFirstService.findById(id_contract), ContractRequest.class));
        Creditor response = mapper.map(request, Creditor.class);
        return mapper.map(repository.save(response), CreditorMatrixResponseId.class);
    }

    @Transactional(readOnly = true)
    public CreditorMatrixResponseId findById(Long id) {
        Optional<Creditor> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Creditor" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), CreditorMatrixResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<CreditorMatrixResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), CreditorMatrixResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Creditor" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
