package br.com.proonto.services;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

import java.util.List;
import java.util.Optional;

import br.com.proonto.models.requests.ContractRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Part;
import br.com.proonto.models.requests.PartRequest;
import br.com.proonto.models.responses.PartResponseId;
import br.com.proonto.repositories.AddressRepository;
import br.com.proonto.repositories.ContactRepository;
import br.com.proonto.repositories.PactRepository;
import br.com.proonto.repositories.PartRepository;

@Service
public class PartService {
    @Autowired
    private PartRepository repository;
    @Autowired
    private AddressRepository addressRespository;
    @Autowired
    private PactRepository pactRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContractFirstService contractService;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    Part part = new Part();

    @Transactional
    public PartResponseId saveUpdate(PartRequest request, Long id_contract) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        request.setCONTRATO(mapper.map(contractService.findById(id_contract), ContractRequest.class));
        return mapper.map(repository.save(mapper.map(request, Part.class)), PartResponseId.class);
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

}