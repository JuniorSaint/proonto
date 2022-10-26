package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Area;
import br.com.proonto.models.requests.AreaRequest;
import br.com.proonto.models.requests.FileRequest;
import br.com.proonto.models.responses.AreaResponseId;
import br.com.proonto.repositories.AreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class AreaService {
    @Autowired
    private AreaRepository repository;
    @Autowired
    private FileService fileService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;

    @Transactional
    public AreaResponseId saveUpdate(AreaRequest request) {
        if (request.getId() != null) {
            AreaResponseId responseBank = findById(request.getId());
        }
        List<FileRequest> fileRequestList = new ArrayList<>();
        for(FileRequest fileArea :  request.getARQUIVOS()){
            fileRequestList.add(fileService.saveUpdate(fileArea));
        }
        request.setARQUIVOS(fileRequestList);
        return mapper.map(repository.save(mapper.map(request, Area.class)), AreaResponseId.class);
    }

    @Transactional(readOnly = true)
    public AreaResponseId findById(Long id) {
        Optional<Area> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Area" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), AreaResponseId.class);
    }
}
