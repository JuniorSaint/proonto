package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.entities.ModalitiesOfOperation;
import br.com.proonto.models.entities.ModalityOfOperation;
import br.com.proonto.models.requests.ModalitiesOfOperationRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.ModalitiesOfOperationResponse;
import br.com.proonto.models.responses.ModalitiesOfOperationResponseId;
import br.com.proonto.models.responses.ModalityOfOperationResponse;
import br.com.proonto.repositories.ModalitiesOfOperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class ModalitiesOfOperationsService {
    @Autowired
    private ModalitiesOfOperationRepository repository;
    @Autowired
    private ModalityOfOperationService service;
    @Autowired
    private ModelMapper mapper;
    ModalitiesOfOperation modalitiesOfOperation = new ModalitiesOfOperation();

    @Transactional
    public ModalitiesOfOperationResponseId saveUpdate(ModalitiesOfOperationRequest request){
        List<ModalityOfOperation> response = service.saveUpdate(request.getMODALIDADESOPERACAO());

        modalitiesOfOperation.setMODALIDADESOPERACAO(response);
        return mapper.map(repository.save(modalitiesOfOperation), ModalitiesOfOperationResponseId.class);
    }

    @Transactional(readOnly = true)
    public ModalitiesOfOperationResponseId findById(Long id) {
        Optional<ModalitiesOfOperation> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Modalities" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), ModalitiesOfOperationResponseId.class);
    }
}
