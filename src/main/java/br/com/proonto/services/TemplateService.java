package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.entities.Template;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.requests.TemplateRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.TemplateResponse;
import br.com.proonto.repositories.BankRepository;
import br.com.proonto.repositories.TemplateRepository;
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
public class TemplateService {
    @Autowired
    private TemplateRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public TemplateResponse saveUpdate(TemplateRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        Template template = mapper.map(request, Template.class);
        return mapper.map(repository.save(template), TemplateResponse.class);
    }

    @Transactional(readOnly = true)
    public TemplateResponse findById(Long id) {
        Optional<Template> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Template" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), TemplateResponse.class);
    }

    @Transactional(readOnly = true)
    public List<TemplateResponse> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), TemplateResponse.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Template" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
