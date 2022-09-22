package br.com.proonto.services;

import br.com.proonto.models.entities.Area;
import br.com.proonto.repositories.AreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {
    @Autowired
    private AreaRepository repository;
    @Autowired
    private ModelMapper mapper;

    Area area = new Area();

}
