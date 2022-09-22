package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.models.entities.PresenterRepresentative;
import br.com.proonto.models.entities.Representative;
import br.com.proonto.models.requests.PresenterRepresentativeRequest;
import br.com.proonto.models.requests.RepresentativeRequest;
import br.com.proonto.models.responses.PresenterRepresentativeResponse;
import br.com.proonto.repositories.AddressRespository;
import br.com.proonto.repositories.ContactRepository;
import br.com.proonto.repositories.PresenterRepresentativeRepository;
import br.com.proonto.repositories.RepresentativeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class PresenterRepresentativeService {
    @Autowired
    private PresenterRepresentativeRepository repository;
    @Autowired
    private AddressRespository addressRespository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private RepresentativeRepository representativeRepository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    public PresenterRepresentativeResponse saveUpdate(PresenterRepresentativeRequest request) {
        if (request.getId() != null) {
            PresenterRepresentativeResponse response = findById(request.getId());
        }
        PresenterRepresentative resp = mapper.map(request, PresenterRepresentative.class);
        resp.setENDERECO(addressRespository.save(mapper.map(request.getENDERECO(), Address.class)));
        resp.setREPRESENTANTE(representativeRepository.save(mapper.map(request.getREPRESENTANTE(), Representative.class)));
        resp.setCONTATO(contactRepository.save(mapper.map(request.getCONTATO(), Contact.class)));
        return mapper.map(repository.save(resp), PresenterRepresentativeResponse.class);
    }

    @Transactional(readOnly = true)
    public PresenterRepresentativeResponse findById(Long id) {
        Optional<PresenterRepresentative> response = repository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Presente or Representative" + NOT_FOUND + "id: " + id);
        return mapper.map(response.get(), PresenterRepresentativeResponse.class);
    }
}
