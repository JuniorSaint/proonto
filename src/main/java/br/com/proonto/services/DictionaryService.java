package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Dictionary;
import br.com.proonto.models.requests.DictionaryRequest;
import br.com.proonto.models.responses.DictionaryResponseId;
import br.com.proonto.repositories.DictionaryRepository;
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
public class DictionaryService {
    @Autowired
    private DictionaryRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    @Transactional
    public DictionaryResponseId saveUpdate(DictionaryRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Dictionary.class)), DictionaryResponseId.class);
    }

    @Transactional(readOnly = true)
    public DictionaryResponseId findById(Long id) {
        Optional<Dictionary> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Dictionary" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), DictionaryResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<DictionaryResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), DictionaryResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Dictionary" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
