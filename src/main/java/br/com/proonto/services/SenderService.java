package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Presenter;
import br.com.proonto.models.entities.Sender;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.PresenterRequest;
import br.com.proonto.models.requests.SenderRequest;
import br.com.proonto.models.responses.PresenterResponseId;
import br.com.proonto.models.responses.SenderResponseId;
import br.com.proonto.repositories.PresenterRepository;
import br.com.proonto.repositories.SenderRepository;
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
public class SenderService {
    @Autowired
    private SenderRepository repository;
    @Autowired
    private ContractFirstService contractFirstService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public SenderResponseId saveUpdate(SenderRequest request, Long id_contract) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        if(repository.findByIdAndContract(id_contract).isPresent() && request.getId() == null){
            throw new BadRequestException("Sender for this contract already exists, It's not allowed more than one for contract");
        }
        request.setCONTRATO(mapper.map(contractFirstService.findById(id_contract), ContractRequest.class));
        return mapper.map(repository.save(mapper.map(request, Sender.class)), SenderResponseId.class);
    }

    @Transactional(readOnly = true)
    public SenderResponseId findById(Long id) {
        Optional<Sender> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Sender" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), SenderResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<SenderResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), SenderResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Sender" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
