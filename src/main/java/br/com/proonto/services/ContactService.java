package br.com.proonto.services;

import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.Contact;
import br.com.proonto.repositories.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;
    @Autowired
    private ModelMapper mapper;

    Contact contact = new Contact();

    @Transactional
    public Contact saveUpdate(Contact contact) {
        if (contact.getId() != null) {
            Contact resp = findById(contact.getId());
        }
        contact.setTELEFONE(contact.getTELEFONE().replaceAll("\\D", ""));
        return repository.save(contact);
    }

    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        Optional<Contact> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("Contact" + NOT_FOUND + "id: " + id);
        }
        return response.get();
    }

    @Transactional
    public String delete(Long id) {
        try {
            Contact response = findById(id);
            repository.delete(response);
            return "Contact" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
