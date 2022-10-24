package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.models.entities.RegistryOffice;
import br.com.proonto.models.requests.RegistryOfficeRequest;
import br.com.proonto.models.responses.RegistryOfficeResponseId;
import br.com.proonto.repositories.RegistryOfficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;

@Service
public class RegistryOfficeService {
    @Autowired
    private RegistryOfficeRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    @Transactional
    public RegistryOffice saveUpdate(RegistryOffice request) {
        Optional<RegistryOffice> response = repository.findByCNS(request.getCNS());
        if (response.isPresent()) {
            return mapper.map(response, RegistryOffice.class);
        }
        RegistryOffice result = mapper.map(request, RegistryOffice.class);
        return repository.save(result);
    }

    @Transactional(readOnly = true)
    public List<RegistryOffice> verifyIfExistAndCreateList(Set<RegistryOfficeRequest> cnsList) {
        List<String> result = new ArrayList<>();
        Iterator<RegistryOfficeRequest> namesIterator = cnsList.iterator();
        while (namesIterator.hasNext()) {
            result.add(namesIterator.next().getCNS());
        }
        return repository.findListRegistryInclude(result);
    }

    public Set<RegistryOffice> verifyIncludeAndSave(Set<RegistryOfficeRequest> cnsList) {
        List<RegistryOffice> registryOffices = verifyIfExistAndCreateList(cnsList);
        Iterator<RegistryOfficeRequest> namesIterator = cnsList.iterator();
        Set<RegistryOffice> resultResgiter = new HashSet<>(registryOffices);
        while (namesIterator.hasNext()) {
            RegistryOfficeRequest entityToCheck = namesIterator.next();
            Integer counter = 0;
            for (int x = 0; x < registryOffices.size(); x++) {
                String strToCheck = registryOffices.get(x).getCNS();
                if (entityToCheck.getCNS().equals(strToCheck)) {
                    counter += 1;
                }
            }
            if (counter == 0) {
                RegistryOffice checkTosave = repository.save(mapper.map(entityToCheck, RegistryOffice.class));
                resultResgiter.add(checkTosave);
            }
        }
        return resultResgiter;
    }


    @Transactional(readOnly = true)
    public RegistryOfficeRequest verifyIfExist(RegistryOfficeRequest cns) {
        Optional<RegistryOffice> result = repository.findByCNS(cns.getCNS());
        if (result.isEmpty()) {
            return cns;
        }
        return mapper.map(result.get(), RegistryOfficeRequest.class);
    }

    @Transactional(readOnly = true)
    public RegistryOfficeRequest findById(Long id) {
        return mapper.map(repository.findById(id).get(), RegistryOfficeRequest.class);
    }

    @Transactional(readOnly = true)
    public List<RegistryOfficeResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), RegistryOfficeResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Registry Office" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
