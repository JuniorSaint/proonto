package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.FileArea;
import br.com.proonto.models.requests.FileRequest;
import br.com.proonto.models.responses.FileResponseId;
import br.com.proonto.repositories.FileRepository;
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
public class FileService {
    @Autowired
    FileRepository repository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    Utils utils;

    @Transactional
    public FileRequest saveUpdate(FileRequest request) {
        if (request.getId() != null) {
            FileResponseId response = findById(request.getId());
        }
        return mapper.map(repository.save( mapper.map(request, FileArea.class)), FileRequest.class);
    }

    @Transactional(readOnly = true)
    public FileResponseId findById(Long id) {
        Optional<FileArea> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("File" + NOT_FOUND + id);
        }
        return mapper.map(response.get(), FileResponseId.class);
    }

    @Transactional(readOnly = true)
    public List<FileResponseId> findAll() {
        return utils.mapListIntoDtoList(repository.findAll(), FileResponseId.class) ;
    }

    @Transactional
    public String delete(Long id) {
        try {
            FileResponseId response = findById(id);
            repository.deleteById(id);
            return "File" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
