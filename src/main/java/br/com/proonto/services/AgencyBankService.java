package br.com.proonto.services;

import java.util.List;
import java.util.Optional;

import br.com.proonto.models.requests.AgencyBankRequest;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.responses.AgencyBankResponseId;
import br.com.proonto.repositories.BankRepository;
import br.com.proonto.repositories.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.AgencyBank;
import br.com.proonto.models.entities.Bank;
import br.com.proonto.repositories.AgencyBankRepository;
import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;


@Service
public class AgencyBankService {
    @Autowired
    private AgencyBankRepository repository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private CreditorMatrixService creditorMatrixService;
    @Autowired
    private Utils utils;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public AgencyBankResponseId saveUpdate(AgencyBankRequest request) {
//        request.setBank(mapper.map(responseBank.get(), BankRequest.class));
        if (request.getId() != null) {
            AgencyBankResponseId response = findById(request.getId());
        }
        if (request.getBank().getId() == null) {
            throw new BadRequestException("It's not allowed register an agency bank without bank");
        }
        Optional<Bank> responseBank = bankRepository.findById(request.getBank().getId());
        if (responseBank.isEmpty()) {
            throw new EntityNotFoundException("Bank" + NOT_FOUND);
        }
        if (request.getCreditor() == null) {
            throw new BadRequestException("It's not allowed register an agency bank without a creditor");
        }
        request.setBank(mapper.map(responseBank.get(), BankRequest.class));
        AgencyBank agencyBank = mapper.map(request, AgencyBank.class);
        return mapper.map(repository.save(agencyBank), AgencyBankResponseId.class);
    }

    @Transactional(readOnly = true)
    public AgencyBankResponseId findById(Long id) {
        Optional<AgencyBank> response = repository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Agency bank" + NOT_FOUND + "id: " + id);
        return mapper.map(response.get(), AgencyBankResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<AgencyBankResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), AgencyBankResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            AgencyBankResponseId response = findById(id);
            repository.deleteById(id);
            return "Agency bank" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
