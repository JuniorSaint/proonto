package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.controllers.BankController;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Bank;
import br.com.proonto.models.requests.BankRequest;
import br.com.proonto.models.responses.BankResponseId;
import br.com.proonto.repositories.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BankService {
    @Autowired
    private BankRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    Bank bank = new Bank();

    @Transactional
    public BankResponseId saveUpdate(BankRequest bankRequest) {
        if (bankRequest.getId() != null) {
            BankResponseId responseBank = findById(bankRequest.getId());
        }
        mapper.map(bankRequest, bank);
        if (bank.getCnpj() != null)
            bank.setCnpj(bank.getCnpj().replaceAll("\\D", ""));

        return mapper.map(repository.save(bank), BankResponseId.class);
    }

    @Transactional(readOnly = true)
    public BankResponseId findById(Long id) {
        Optional<Bank> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Bank" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), BankResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<BankResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), BankResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            BankResponseId response = findById(id);
            repository.deleteById(id);
            return "Bank" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
