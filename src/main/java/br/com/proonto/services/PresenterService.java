package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Presenter;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.PresenterRequest;
import br.com.proonto.models.responses.ContractFirstResponse;
import br.com.proonto.models.responses.PresenterResponseId;
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
    private ContractFirstService contractFirstService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    @Transactional
    public PresenterResponseId saveUpdate(PresenterRequest request, Long id_contract) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        contractFirstService.findById(id_contract);
        if (repository.findByIdAndContract(id_contract).isPresent() && request.getId() == null) {
            throw new BadRequestException("Presenter for this contract already exists, It's not allowed more than one for contract");
        }
        request.setCONTRATO(mapper.map(contractFirstService.findById(id_contract), ContractRequest.class));
        return mapper.map(repository.save(mapper.map(request, Presenter.class)), PresenterResponseId.class);
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
