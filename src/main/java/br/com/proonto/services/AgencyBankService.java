package br.com.proonto.services;

import java.util.List;
import java.util.Optional;

import br.com.proonto.models.requests.AgencyBankRequest;
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
import br.com.proonto.models.entities.Contact;
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
    private Utils utils;
    @Autowired
    private ModelMapper mapper;

    AgencyBank agencyBank = new AgencyBank();

    @Transactional
    public AgencyBankResponseId saveUpdate(AgencyBankRequest agencyBankRequest) {
        if (agencyBankRequest.getId() != null) {
            AgencyBankResponseId response = findById(agencyBankRequest.getId());
        }
        if (agencyBankRequest.getBank().getId() == null)
            throw new BadRequestException("It's not allowed agency without bank");

        Contact re = agencyBankRequest.getContact() != null ? contactRepository.save(mapper.map(agencyBankRequest.getContact(), Contact.class)) : new Contact();
        Optional<Bank> reBank = bankRepository.findById(agencyBankRequest.getBank().getId());
        if (reBank.isEmpty()) throw new EntityNotFoundException("Bank" + NOT_FOUND);
        mapper.map(agencyBankRequest, agencyBank);
        agencyBank.setBank(reBank.get());
        agencyBank.setContact(re);
        AgencyBank res = repository.save(agencyBank);
        return mapper.map(res, AgencyBankResponseId.class);
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
