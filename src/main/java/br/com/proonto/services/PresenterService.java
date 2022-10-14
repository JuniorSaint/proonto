package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Creditor;
import br.com.proonto.models.entities.Presenter;
import br.com.proonto.models.requests.CreditorRequest;
import br.com.proonto.models.requests.PresenterRequest;
import br.com.proonto.models.responses.CreditorResponseId;
import br.com.proonto.models.responses.PresenterResponse;
import br.com.proonto.models.responses.PresenterResponseId;
import br.com.proonto.repositories.CreditorRepository;
import br.com.proonto.repositories.PresenterRepository;
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
public class PresenterService {
    @Autowired
    private PresenterRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public PresenterResponseId saveUpdate(PresenterRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        Presenter response = mapper.map(request, Presenter.class);
        if (response.getCPFCNPJ() != null)
            response.setCPFCNPJ(response.getCPFCNPJ().replaceAll("\\D", ""));

        return mapper.map(repository.save(response), PresenterResponseId.class);
    }

    @Transactional(readOnly = true)
    public PresenterResponseId findById(Long id) {
        Optional<Presenter> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Presenter" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), PresenterResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<PresenterResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), PresenterResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Presenter" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
