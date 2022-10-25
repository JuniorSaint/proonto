package br.com.proonto.services;

import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contract;
import br.com.proonto.models.entities.Guarantee;
import br.com.proonto.models.requests.ContractFirstRequest;
import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.requests.GuaranteeRequest;
import br.com.proonto.models.responses.GuaranteeResponse;
import br.com.proonto.models.responses.GuaranteeResponseId;
import br.com.proonto.repositories.GuaranteeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class GuaranteeService {
    @Autowired
    private GuaranteeRepository repository;
    @Autowired
    private ContractFirstService contractFirstService;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public GuaranteeResponseId saveUpdate(GuaranteeRequest request, Long id) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        request.setCONTRATO(mapper.map(contractFirstService.findById(id), ContractRequest.class));

        return mapper.map(repository.save(mapper.map(request, Guarantee.class)), GuaranteeResponseId.class);
    }

    @Transactional(readOnly = true)
    public GuaranteeResponseId findById(Long id) {
        Optional<Guarantee> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Gurantee" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), GuaranteeResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Guarantee" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
