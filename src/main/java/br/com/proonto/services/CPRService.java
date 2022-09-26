package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.CPR;
import br.com.proonto.models.requests.CPRRequest;
import br.com.proonto.models.responses.CPRResponse;
import br.com.proonto.repositories.CPRRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class CPRService {
    @Autowired
    private CPRRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public CPRResponse saveUpdate(CPRRequest request) {
        if (request.getId() != null) {
            CPRResponse resp = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, CPR.class)), CPRResponse.class);
    }

    public CPRResponse findById(Long id) {
        Optional<CPR> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("CPR" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, CPRResponse.class);
    }
}