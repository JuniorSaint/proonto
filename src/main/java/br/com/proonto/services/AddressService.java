package br.com.proonto.services;

import br.com.proonto.configs.CP;
import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Address;
import br.com.proonto.models.entities.AddressType;
import br.com.proonto.models.requests.AddressRequest;
import br.com.proonto.models.responses.AddressResponseId;
import br.com.proonto.repositories.AddressRepository;
import br.com.proonto.repositories.AddressTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private AddressTypeRepository addressTypeRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    Address address = new Address();

    @Transactional
    public Address saveUpdate(AddressRequest request) {
        if (request.getId() != null) {
            findById(request.getId());
        }
        mapper.map(request, address);
        address.setTIPOLOGRADOURO(findByIdAddressType(request.getTIPOLOGRADOURO().getCode()));
        return repository.save(address);
    }

    private AddressType findByIdAddressType(String id){
      Optional<AddressType> response = addressTypeRepository.findById(id);
      if(response.isEmpty()){
          throw new EntityNotFoundException("Address type" + NOT_FOUND + " id: " + id);
      }
      return response.get();
    }

    @Transactional(readOnly = true)
    public AddressResponseId findById(Long id) {
        Optional<Address> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Address" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), AddressResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<AddressResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), AddressResponseId.class);
    }

    @Transactional
    public String delete(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
            return "Address" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
