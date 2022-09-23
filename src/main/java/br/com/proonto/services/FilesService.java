package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.FileArea;
import br.com.proonto.models.entities.FilesArea;
import br.com.proonto.models.requests.FileRequest;
import br.com.proonto.models.requests.FilesRequest;
import br.com.proonto.models.responses.FileResponse;
import br.com.proonto.models.responses.FileResponseId;
import br.com.proonto.models.responses.FilesResponse;
import br.com.proonto.repositories.FileRepository;
import br.com.proonto.repositories.FilesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class FilesService {
    @Autowired
    private FilesRepository repository;
    @Autowired
    private FileService fileService;
    @Autowired
    ModelMapper mapper;
    @Autowired
    Utils utils;

    @Transactional
    public FilesRequest saveUpdate(FilesRequest request) {
        if (request.getId() != null) {
            FilesResponse response = findById(request.getId());
        }
        return mapper.map(repository.save(mapper.map(request, FilesArea.class)), FilesRequest.class);
    }

    @Transactional(readOnly = true)
    public FilesResponse findById(Long id) {
        Optional<FilesArea> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Files" + NOT_FOUND + id);
        }
        return mapper.map(response.get(), FilesResponse.class);
    }
}
