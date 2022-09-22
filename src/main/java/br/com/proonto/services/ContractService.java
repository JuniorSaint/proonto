package br.com.proonto.services;

import br.com.proonto.models.requests.ContractRequest;
import br.com.proonto.models.responses.ContractResponse;
import br.com.proonto.repositories.ContractRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractService {
    @Autowired
    private ContractRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    private ContractResponse saveUpadate(ContractRequest contractRequest) {
        return null;
    }
}
