package br.com.proonto.services;

import static br.com.proonto.configs.CP.NOT_FOUND;

import java.util.Optional;

import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.models.requests.ContractRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Financial;
import br.com.proonto.models.requests.FinancialRequest;
import br.com.proonto.models.responses.FinancialResponseId;
import br.com.proonto.repositories.FinancialRepository;

@Service
public class FinancialService {
    @Autowired
    private FinancialRepository repository;
    @Autowired
    private ContractFirstService contractFirstService;
    @Autowired
    ModelMapper mapper;
    Financial financial = new Financial();

    @Transactional
    public FinancialResponseId saveUpdate(FinancialRequest request, Long id_contract) {
        if (request.getId() != null) {
            FinancialResponseId responseBank = findById(request.getId());
        }
        if(contractFirstService.findById(id_contract) != null && request.getId() == null){
            throw new BadRequestException("Financial for this contract already exists, It's not allowed more than one for contract");
        }
        request.setCONTRATO(mapper.map(contractFirstService.findById(id_contract), ContractRequest.class));
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
