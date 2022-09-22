package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.controllers.PartController;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Part;
import br.com.proonto.repositories.AddressRespository;
import br.com.proonto.repositories.PartRepository;
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
public class PartService {
    @Autowired
    private PartRepository repository;
    @Autowired
    private AddressRespository addressRespository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    Part part = new Part();

    @Transactional
    public Part saveUpdate(Part part) {
        if (part.getId() != null) {
            Part resp = findById(part.getId());
        }
        if (part.getCPFCNPJ() != null) {
            part.setCPFCNPJ(part.getCPFCNPJ().replaceAll("\\D", ""));
        }
        part.setENDERECO(addressRespository.save(part.getENDERECO()));
        Part response = repository.save(part);
        return response;
    }

    @Transactional(readOnly = true)
    public Part findById(Long id) {
        Optional<Part> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Part"+ NOT_FOUND + "id: "  + id);
        }
        return response.get();
    }

    @Transactional(readOnly = true)
    public Part findByCnpj(String cnpj) {
        Optional<Part> response = repository.findByCnpjCpf(cnpj);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Part" + NOT_FOUND + "cnpj/cpf: " + cnpj);
        }
        return response.get();
    }

    @Transactional(readOnly = true)
    public List<Part> findAll() {
        List<Part> response = repository.findAll();
        return response;
    }

    @Transactional(readOnly = true)
    public String delete(Long id) {
        try {
            Part response = findById(id);
            repository.delete(response);
            return "Part" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
