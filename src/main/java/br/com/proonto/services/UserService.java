package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.controllers.UserController;
import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.exceptions.DataBaseException;
import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.entities.User;
import br.com.proonto.models.requests.ChangePasswordRequest;
import br.com.proonto.models.requests.UserRequestPut;
import br.com.proonto.models.responses.UserResponse;
import br.com.proonto.repositories.PermissionRepository;
import br.com.proonto.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

import static br.com.proonto.configs.CP.DELETE_MESSAGE;
import static br.com.proonto.configs.CP.NOT_FOUND;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;
    //    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private Utils utils;
    @Autowired
    private PermissionRepository permissionRepository;

    UserResponse userResponse = new UserResponse();
    User userEntity = new User();

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> users = repository.findByEmail(email);
//        if (users.isEmpty()) {
//            throw new EntityNotFoundException("Email " + email + "or password is not correct");
//        }
//        return users.get();
//    }

    @Transactional
    public UserResponse saveUpdate(UserRequestPut userRequestPut) {
        if (userRequestPut.getId() != null) {
            UserResponse user = findById(userRequestPut.getId());
        } else {
            Optional<User> searchForUser = repository.findByEmail(userRequestPut.getEmail());
            if (searchForUser.isPresent()) {
                throw new BadRequestException(
                        "Already exist user with this email: " + userRequestPut.getEmail() + ", try with another one");
            }
        }
        mapper.map(userRequestPut, userEntity);
//        userEntity.setPassword(encodePassword(userRequestPut.getPassword()));
        if (userEntity.getCpf() != null) {
            userEntity.setCpf(userEntity.getCpf().replaceAll("\\D", ""));
        }
        User response = repository.save(userEntity);
        return mapper.map(response, UserResponse.class);
    }

    @Transactional
    public String changePassword(ChangePasswordRequest request) {
        Optional<User> user = repository.findById(request.getId());
//        user.get().setPassword(encodePassword(request.getPassword()));
        User userUpdate = repository.save(user.get());
        return "The password was changed with success!";
    }

    @Transactional
    public String delete(Long id) {
        try {
            repository.deleteById(id);
            return "User" + DELETE_MESSAGE;
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Object is linked, deleting is not allowed.");
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("User" + NOT_FOUND + "id: " + id);
        }
    }

    @Transactional(readOnly = true)
    public UserResponse findById(Long id) {
        Optional<User> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("User" + NOT_FOUND + "id: " + id);
        }
        return mapper.map(response.get(), UserResponse.class);
    }

    @Transactional(readOnly = true)
    public UserResponse findByEmail(String email) {
        Optional<User> response = repository.findByEmail(email);
        if (response.isEmpty()) {
            throw new EntityNotFoundException("User" + NOT_FOUND + "email: " + email);
        }
        return mapper.map(response.get(), UserResponse.class);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> findAllWithPageSeek(String search, Pageable pageable) {
        Page<User> responses = repository.findByNameOrEmail(search, pageable);
        return utils.mapEntityPageIntoDtoPage(responses, UserResponse.class);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        List<User> response = repository.findAll();
        return utils.mapListIntoDtoList(response, UserResponse.class);
    }

//    public String validatePassword(LogInRequest logInRequest) {
//        Optional<User> userResponse = repository.findByEmail(logInRequest.getEmail());
//        if (userResponse.isEmpty()) {
//            throw new NotAuthorizateException("there isn't authorization, password or email invalid.");
//        }
//        User user = userResponse.get();
//        boolean valid = passwordEncoder.matches(logInRequest.getPassword(), user.getPassword());
////
//        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//        return ResponseEntity.status(status).body(valid);
//        return null;
//    }

    // Convert entity to Dto
    @Transactional(readOnly = true)
    public Page<UserResponse> findAllWithPage(Pageable pageable) {
        Page<User> responses = repository.findAll(pageable);
        return utils.mapEntityPageIntoDtoPage(responses, UserResponse.class);
    }

//    private String encodePassword(String password) {
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
//        passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder());
//        return passwordEncoder.encode(password);
//    }
}
