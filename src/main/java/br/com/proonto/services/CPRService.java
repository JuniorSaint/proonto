package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.CPR;
import br.com.proonto.models.entities.Registry;
import br.com.proonto.models.entities.RegistryOffice;
import br.com.proonto.models.requests.*;
import br.com.proonto.models.responses.CPRResponse;
import br.com.proonto.models.responses.CPRResponseId;
import br.com.proonto.repositories.CPRRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class CPRService {
    @Autowired
    private CPRRepository repository;
    @Autowired
    private ContractFirstService contractFirstService;
    @Autowired
    private RegistryOfficeService registryOfficeService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;


    @Transactional
    public CPRResponseId saveUpdate(CPRRequest request, Long id_contract) {
        if (request.getId() != null) {
            findById(request.getId());
        }

        if(repository.findByIdAndContract(id_contract).isPresent() && request.getId() == null){
            throw new BadRequestException("Cpr for this contract already exists, It's not allowed more than one for contract");
        }

        Set<RegistryOfficeRequest> getCnsFromGuarantee = new HashSet<>(request.getPRODUTOS().stream().map(r -> r.getLOCALPRODUCAO().getREGISTRO().getCNS()).collect(Collectors.toList()));
        Set<RegistryOffice> registryOfficeRequest = registryOfficeService.verifyIncludeAndSave(getCnsFromGuarantee);
        List<ProductRequest> listResgitr =  request.getPRODUTOS().stream().map(r -> {
            Iterator<RegistryOffice> namesIterator = registryOfficeRequest.iterator();
            while (namesIterator.hasNext()) {
                RegistryOffice registerOfficeFromIterator = namesIterator.next();
                if (r.getLOCALPRODUCAO().getREGISTRO().getCNS().getCNS().equals(registerOfficeFromIterator.getCNS())) {
                    r.getLOCALPRODUCAO().getREGISTRO().setCNS(mapper.map(registerOfficeFromIterator, RegistryOfficeRequest.class));
                }
            }
            return r;
        }).collect(Collectors.toList());
        request.setCONTRATO(mapper.map(contractFirstService.findById(id_contract), ContractRequest.class));
        return mapper.map(repository.save(mapper.map(request, CPR.class)), CPRResponseId.class);
    }

    @Transactional(readOnly = true)
    public CPRResponse findById(Long id) {
        Optional<CPR> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("CPR" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response, CPRResponse.class);
    }
}
