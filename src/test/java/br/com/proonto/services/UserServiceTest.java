//package br.com.proonto.services;
//
//import br.com.proonto.configs.Utils;
//import br.com.proonto.exceptions.BadRequestException;
//import br.com.proonto.exceptions.DataBaseException;
//import br.com.proonto.exceptions.EntityNotFoundException;
//import br.com.proonto.models.entities.User;
//import br.com.proonto.models.responses.UserResponse;
//import br.com.proonto.repositories.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.modelmapper.ModelMapper;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//import java.util.Optional;
//
//import static br.com.proonto.mocks.MessageMock.ID;
//import static br.com.proonto.mocks.MessageMock.ID_ZERO;
//import static br.com.proonto.mocks.UserMock.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
//class UserServiceTest {
//    @InjectMocks
//    private UserService service;
//    @Mock
//    private UserRepository repository;
//    @Mock
//    private ModelMapper mapper;
//    @Mock
//    private Utils utils;
//
//    private User user = new User();
//    private PageImpl<User> page;
//    private Pageable pageable;
//
//    @BeforeEach
//    void setUp() {
//        page = new PageImpl<>(List.of(USER_ENTITY));
//        Pageable pageable = PageRequest.of(0, 10);
//    }
//
//    @Test
//    @DisplayName("Should save or update the object with - success ")
//    void saveUpdateWithSuccess() {
//        when(repository.save(USER_ENTITY)).thenReturn(USER_ENTITY);
//        UserResponse response = service.saveUpdate(USER_REQUEST_PUT);
//        verify(repository, times(1)).save(any());
//    }
//
//    @Test
//    @DisplayName("Should not save or update the object")
//    void saveWithFail() {
//        when(repository.findByEmail(anyString())).thenReturn(Optional.of(USER_ENTITY));
//        USER_REQUEST_PUT.setId(null);
//        assertThrows(BadRequestException.class, () -> {
//            service.saveUpdate(USER_REQUEST_PUT);
//        });
//        verify(repository, times(1)).findByEmail(anyString());
//    }
//
//    @Test
//    @DisplayName("Should change the password with - success ")
//    void changePassword() {
//        when(repository.findById(anyLong())).thenReturn(Optional.of(USER_ENTITY));
//        service.changePassword(CHANGE_PASSWORD_REQUEST);
//        verify(repository, times(1)).findById(anyLong());
//    }
//
//    @Test
//    @DisplayName("Should return one objects with specific id - success ")
//    void findByIdWithSuccess() {
//        when(repository.findById(anyLong())).thenReturn(Optional.of(USER_ENTITY));
//        when(service.findById(anyLong())).thenReturn(USER_RESPONSE);
//        UserResponse response = service.findById(anyLong());
//        verify(repository, times(2)).findById(anyLong());
//        assertNotNull(response);
//        assertEquals(response.getClass(), UserResponse.class);
//    }
//
//    @Test
//    @DisplayName("Should not return one objects with specific id - fail ")
//    void findByIdWithFail() {
//        when(repository.findById(anyLong())).thenReturn(Optional.empty());
//        assertThrows(EntityNotFoundException.class, () -> {
//            service.findById(anyLong());
//        });
//        verify(repository, times(1)).findById(anyLong());
//    }
//
//    @Test
//    @DisplayName("Should return one objects with specific email - success ")
//    void findByEmailWithSuccess() {
//        when(repository.findByEmail(anyString())).thenReturn(Optional.of(USER_ENTITY));
//        UserResponse response = service.findByEmail(anyString());
//        verify(repository, times(1)).findByEmail(anyString());
//    }
//
//    @Test
//    @DisplayName("Should return one objects with specific email - success ")
//    void findByEmailWithFail() {
//        when(repository.findByEmail(anyString())).thenReturn(Optional.empty());
//        assertThrows(EntityNotFoundException.class, () -> {
//            service.findByEmail(anyString());
//        });
//        verify(repository, times(1)).findByEmail(anyString());
//    }
//
//
//    @Test
//    @DisplayName("Should return all objects with page and specific word- success ")
//    void findAllWithPageSeek() {
//        when(repository.findByNameOrEmail(anyString(), (Pageable) any())).thenReturn(page);
//        Page<UserResponse> response = service.findAllWithPageSeek(eq(anyString()), pageable);
//        assertTrue(Page.empty().isEmpty());
//    }
//
//    @Test
//    @DisplayName("Should return all objects with - success ")
//    void findAll() {
//        when(repository.findAll()).thenReturn(List.of(USER_ENTITY));
//        List<UserResponse> response = service.findAll();
//        verify(repository, times(1)).findAll();
//    }
//
//    @Test
//    @DisplayName("Should return the objects with pageable - success ")
//    void findAllWithPage() {
//        when(repository.findAll((Pageable) any())).thenReturn(page);
//        Page<UserResponse> response = service.findAllWithPage(pageable);
//        verify(repository, times(1)).findAll(pageable);
//    }
//
//    @Test
//    @DisplayName("Should delete a object with - success")
//    void deleteWithSuccess() {
//        doNothing().when(repository).deleteById(ID);
//        service.delete(anyLong());
//        verify(repository, times(1)).deleteById(anyLong());
//    }
//
//    @Test
//    @DisplayName("Should delete a object with fail - Empty Result ")
//    void deleteWithFailEmptyResult() {
//        doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(ID_ZERO);
//        assertThrows(EntityNotFoundException.class, () -> {
//            service.delete(ID_ZERO);
//        });
//        verify(repository, times(1)).deleteById(anyLong());
//    }
//
//    @Test
//    @DisplayName("Should delete a object with fail - Data Integrity ")
//    void deleteWithFailDataIntegrity() {
//        doThrow(DataIntegrityViolationException.class).when(repository).deleteById(ID_ZERO);
//        assertThrows(DataBaseException.class, () -> {
//            service.delete(ID_ZERO);
//        });
//        verify(repository, times(1)).deleteById(anyLong());
//    }
//}