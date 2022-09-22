package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.models.entities.ModalitiesOfOperation;
import br.com.proonto.models.entities.ModalityOfOperation;
import br.com.proonto.models.requests.ModalitiesOfOperationRequest;
import br.com.proonto.models.requests.ModalityOfOperationRequest;
import br.com.proonto.models.responses.ModalitiesOfOperationResponseId;
import br.com.proonto.models.responses.ModalityOfOperationResponse;
import br.com.proonto.repositories.ModalitiesOfOperationRepository;
import br.com.proonto.repositories.ModalityOfOperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModalityOfOperationService {
    @Autowired
    private ModalityOfOperationRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    ModalityOfOperation modalityOfOperation = new ModalityOfOperation();

    @Transactional
    public List<ModalityOfOperation> saveUpdate(List<ModalityOfOperationRequest> request) {
        List<ModalityOfOperation> modality = new ArrayList<>();
        for (ModalityOfOperationRequest mod : request) {
            modality.add(repository.save(mapper.map(mod, ModalityOfOperation.class)));
        }
        return modality;
    }
}
