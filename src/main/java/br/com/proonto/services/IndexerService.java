package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Indexer;
import br.com.proonto.models.requests.IndexerRequest;
import br.com.proonto.models.responses.IndexerResponse;
import br.com.proonto.repositories.IndexerRepository;
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
public class IndexerService {
    @Autowired
    private IndexerRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    @Transactional
    public IndexerResponse saveUpdate(IndexerRequest request) {
        if (request.getDomain() != null) {
            IndexerResponse responseBank = findById(request.getDomain());
        }
        Indexer indexer =  mapper.map(request, Indexer.class);
        return mapper.map(repository.save(indexer), IndexerResponse.class);
    }

    @Transactional(readOnly = true)
    public IndexerResponse findById(String id) {
        Optional<Indexer> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Indexer" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), IndexerResponse.class);
    }

    @Transactional(readOnly = true)
    public List<IndexerResponse> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), IndexerResponse.class);
    }

    @Transactional
    public String delete(String id) {
        try {
            IndexerResponse response = findById(id);
            repository.deleteById(id);
            return "Indexer" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

}
