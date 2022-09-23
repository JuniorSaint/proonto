package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Guarantee;
import br.com.proonto.models.entities.Registry;
import br.com.proonto.models.requests.GuaranteeRequest;
import br.com.proonto.models.responses.GuaranteeResponse;
import br.com.proonto.models.responses.RegistryResponse;
import br.com.proonto.repositories.GuaranteeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class GuaranteeService {
    @Autowired
    private GuaranteeRepository repository;
    @Autowired
    private ModelMapper mapper;

//    public GuaranteeRequest saveUpdate(){
//        if (request.getId() != null) {
//            RegistryResponse resp = findById(request.getId());
//        }
//    }

    public GuaranteeResponse findById(Long id){
        Optional<Guarantee> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Gurantee" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), GuaranteeResponse.class);
    }
}
