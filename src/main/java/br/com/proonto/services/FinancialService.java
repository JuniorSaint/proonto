package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.entities.Financial;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.requests.FinancialRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.models.responses.FinancialResponseId;
import br.com.proonto.repositories.FinancialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class FinancialService {
    @Autowired
    private FinancialRepository repository;
    @Autowired
    ModelMapper mapper;
    Financial financial = new Financial();

    @Transactional
    public FinancialResponseId saveUpdate(FinancialRequest request) {
        if (request.getId() != null) {
            FinancialResponseId responseBank = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, Financial.class)), FinancialResponseId.class);
    }

    @Transactional(readOnly = true)
    public FinancialResponseId findById(Long id) {
        Optional<Financial> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Financial" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), FinancialResponseId.class);
    }

}
