package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.ModalitiesOfOperation;
import br.com.proonto.models.entities.ModalityOfOperation;
import br.com.proonto.models.requests.ModalitiesOfOperationRequest;
import br.com.proonto.models.requests.ModalityOfOperationRequest;
import br.com.proonto.models.responses.ModalitiesOfOperationResponseId;
import br.com.proonto.repositories.ModalitiesOfOperationRepository;
import br.com.proonto.repositories.ModalityOfOperationRepository;
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
    private ModalityOfOperationRepository modalityRepository;
    @Autowired
    private ModelMapper mapper;
    ModalitiesOfOperation modalitiesOfOperation = new ModalitiesOfOperation();

    @Transactional
    public ModalitiesOfOperationResponseId saveUpdate(ModalitiesOfOperationRequest request){
        ModalitiesOfOperation resp = repository.save(mapper.map(request,ModalitiesOfOperation.class));
        List<ModalityOfOperation> modality = new ArrayList<>();
        for (ModalityOfOperationRequest mod : request.getMODALIDADESOPERACAO()) {
            mod.setMODALIDADESOPERACAO(resp);
            modality.add(modalityRepository.save(mapper.map(mod, ModalityOfOperation.class)));
        }
        return mapper.map(resp, ModalitiesOfOperationResponseId.class);
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
