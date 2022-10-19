package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.requests.CreditorBranchRequest;
import br.com.proonto.models.responses.CreditorBranchResponse;
import br.com.proonto.models.responses.CreditorBranchResponseId;
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
public class CreditorBranchService {
    @Autowired
    private CreditorRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    Contact contact = new Contact();

    @Transactional
    public CreditorBranchResponseId saveUpdate(CreditorBranchRequest request) {

        if (request.getId() != null) {
            findById(request.getId());
        }
        Creditor response = mapper.map(request, Creditor.class);
        response.setCPFCNPJ(response.getCPFCNPJ().replaceAll("\\D", ""));
        return mapper.map(repository.save(response), CreditorBranchResponseId.class);
    }

    @Transactional(readOnly = true)
    public CreditorBranchResponseId findById(Long id) {
        Optional<Creditor> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Creditor Branch" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), CreditorBranchResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<CreditorBranchResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), CreditorBranchResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Creditor Branch" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
