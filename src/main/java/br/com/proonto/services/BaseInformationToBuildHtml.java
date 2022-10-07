package br.com.proonto.services;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.*;
import br.com.proonto.models.responses.*;
import br.com.proonto.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;


@Service
public class BaseInformationToBuildHtml {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private PersonTypeRepository personTypeRepository;
    @Autowired
    private IndexerRepository indexerRepository;
    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private MaritalStatusRepository maritalStatusRepository;
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;
    @Autowired
    private ModelMapper mapper;




    @Transactional(readOnly = true)
    public CurrencyResponse currency(String str){
        Optional<Currency> response = currencyRepository.findById(str);
        if(response.isEmpty()){
            throw new EntityNotFoundException("Currency" + NOT_FOUND + "id: " + str);
        }
        return mapper.map(response.get(), CurrencyResponse.class);
    }

    @Transactional(readOnly = true)
    public PersonTypeResponse personType(String str){
        Optional<PersonType> response = personTypeRepository.findById(str);
        if(response.isEmpty()){
            throw new EntityNotFoundException("Person type" + NOT_FOUND + "id: " + str);
        }
        return mapper.map(response.get(), PersonTypeResponse.class);
    }

    @Transactional(readOnly = true)
    public IndexerResponse indexer(String str){
        Optional<Indexer> response = indexerRepository.findById(str);
        if(response.isEmpty()){
            throw new EntityNotFoundException("Indexer" + NOT_FOUND + "id: " + str);
        }
        return mapper.map(response.get(), IndexerResponse.class);
    }

    @Transactional(readOnly = true)
    public QualificationResponseId qualification(Long id){
        Optional<Qualification> response = qualificationRepository.findById(id);
        if(response.isEmpty()){
            throw new EntityNotFoundException("Qualification" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), QualificationResponseId.class);
    }

    @Transactional(readOnly = true)
    public MaritalStatusResponse qualification(String str){
        Optional<MaritalStatus> response = maritalStatusRepository.findById(str);
        if(response.isEmpty()){
            throw new EntityNotFoundException("Marital status" + NOT_FOUND + "id: " + str);
        }
        return mapper.map(response.get(), MaritalStatusResponse.class);
    }

    @Transactional(readOnly = true)
    public PropertyType findById(String id) {
        Optional<PropertyType> response = propertyTypeRepository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Property type" + NOT_FOUND + "id: " + id);
        }
        return response.get();
    }
}
