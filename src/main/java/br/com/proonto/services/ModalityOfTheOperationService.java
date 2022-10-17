package br.com.proonto.services;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.ModalityOfTheOperation;
import br.com.proonto.models.requests.ModalityOfTheOperationRequest;
import br.com.proonto.models.responses.ModalityOfTheOperationResponse;
import br.com.proonto.repositories.ModalityOfTheOperationRepository;

@Service
public class ModalityOfTheOperationService {
    @Autowired
    private ModalityOfTheOperationRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public ModalityOfTheOperationResponse saveUpdate(ModalityOfTheOperationRequest request) {
        if (request.getDomain() != null) {
            ModalityOfTheOperationResponse responseBank = findById(request.getDomain());
        }
        return mapper.map(repository.save(mapper.map(request, ModalityOfTheOperation.class)), ModalityOfTheOperationResponse.class);
    }

    @Transactional(readOnly = true)
    public ModalityOfTheOperationResponse findById(String id) {
        Optional<ModalityOfTheOperation> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Modality of the operation" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), ModalityOfTheOperationResponse.class);
    }

    @Transactional(readOnly = true)
    public List<ModalityOfTheOperationResponse> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), ModalityOfTheOperationResponse.class);
    }

    @Transactional
    public String delete(String id) {
        try {
            ModalityOfTheOperationResponse response = findById(id);
            repository.deleteById(id);
            return "Modality of the operation" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
