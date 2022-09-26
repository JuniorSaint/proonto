package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.models.responses.StatesTableResponse;
import br.com.proonto.repositories.StatesTableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatesTableService {
    @Autowired
    private StatesTableRepository repository;
    @Autowired
    private Utils utils;
    @Autowired
    private ModelMapper mapper;

    public List<StatesTableResponse> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), StatesTableResponse.class);
    }

    public StatesTableResponse findById(String id){
        return mapper.map(repository.findById(id), StatesTableResponse.class);
    }
}
