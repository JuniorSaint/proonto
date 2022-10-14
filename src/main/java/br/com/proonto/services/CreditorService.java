package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.requests.CreditorRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.CreditorResponseId;
import br.com.proonto.repositories.BankRepository;
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
public class CreditorService {
    @Autowired
    private CreditorRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public CreditorResponseId saveUpdate(CreditorRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        Creditor response = mapper.map(request, Creditor.class);
        if (response.getCPFCNPJ() != null)
            response.setCPFCNPJ(response.getCPFCNPJ().replaceAll("\\D", ""));

        return mapper.map(repository.save(response), CreditorResponseId.class);
    }

    @Transactional(readOnly = true)
    public CreditorResponseId findById(Long id) {
        Optional<Creditor> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Creditor" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), CreditorResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<CreditorResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), CreditorResponseId.class);
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
