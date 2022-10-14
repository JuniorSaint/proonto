package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.controllers.PartController;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.*;
import br.com.proonto.models.requests.PartRequest;
import br.com.proonto.models.requests.QualificationRequest;
import br.com.proonto.models.responses.PartResponse;
import br.com.proonto.models.responses.PartResponseId;
import br.com.proonto.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PartService {
    @Autowired
    private PartRepository repository;
    @Autowired
    private AddressRespository addressRespository;
    @Autowired
    private PactRepository pactRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    Part part = new Part();

    @Transactional
    public PartResponseId saveUpdate(PartRequest part) {
        if (part.getId() != null) {
            PartResponseId resp = findById(part.getId());
        }
        if (part.getCPFCNPJ() != null) {
            part.setCPFCNPJ(part.getCPFCNPJ().replaceAll("\\D", ""));
        }
        List<Qualification> res = new ArrayList<>();
        for (QualificationRequest req : part.getQUALIFICACOES()) {
            res.add(qualificationRepository.save(mapper.map(req, Qualification.class)));
        }
        Part response = mapper.map(part, Part.class);
        response.setENDERECO(addressRespository.save(mapper.map(part.getENDERECO(), Address.class)));
        response.setCONTATO(contactRepository.save(mapper.map(part.getCONTATO(), Contact.class)));
        response.setQUALIFICACOES(res);
        Part result = repository.save(response);
        return mapper.map(result, PartResponseId.class);
    }

    @Transactional(readOnly = true)
    public PartResponseId findById(Long id) {
        Optional<Part> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Part" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, PartResponseId.class);
    }

    @Transactional(readOnly = true)
    public PartResponseId findByCnpj(String cnpj) {
        Optional<Part> response = repository.findByCnpjCpf(cnpj);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Part" + NOT_FOUND + "cnpj/cpf: " + cnpj);
        }
        return mapper.map(response, PartResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<PartResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), PartResponseId.class);
    }

    @Transactional(readOnly = true)
    public String delete(Long id) {
        try {
            PartResponseId response = findById(id);
            repository.deleteById(id);
            return "Part" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
