package br.com.proonto.controllers;

import br.com.proonto.exceptions.EntityNotFoundException;
import br.com.proonto.models.responses.UserResponse;
import br.com.proonto.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static br.com.proonto.mocks.MessageMock.ID;
import static br.com.proonto.mocks.MessageMock.ID_ZERO;
import static br.com.proonto.mocks.UserMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockBean
    private UserService service;
    @MockBean
    private UserController controller;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private PageImpl<UserResponse> page;
    private Pageable pageable;
    private String uri = "";

    @BeforeEach
    void setUp() {
        page = new PageImpl<>(List.of(USER_RESPONSE));
        uri = "/v1/users";
        Pageable pageable = PageRequest.of(0, 10);
    }

    @Test
    @DisplayName("Should return one objects by Id")
    void findByIdWithSuccess() throws Exception {
        when(service.findById(eq(ID))).thenReturn(USER_RESPONSE);
        ResultActions mvc = mockMvc.perform(get(uri + "/{id}", ID).accept(MediaType.APPLICATION_JSON));
        mvc.andExpect(status().isOk());
        mvc.andExpect(jsonPath("$.id").exists());
    }

    @Test
    @DisplayName("Should return one exception")
    void findByIdWithFail() throws Exception {
        when(service.findById(eq(ID_ZERO))).thenThrow(EntityNotFoundException.class);
        ResultActions mvc = mockMvc.perform(get(uri + "/{id}", ID_ZERO).accept(MediaType.APPLICATION_JSON));
        mvc.andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("Should return the objects with pageable - success")
    void findAllUserWithSearchWhitSuccess() throws Exception {
        when(service.findAllWithPageSeek(anyString(), pageable)).thenReturn(page);
        ResultActions mvc = mockMvc.perform(get(uri + "/search").accept(MediaType.APPLICATION_JSON));
        mvc.andExpect(status().isOk());
    }

    @Test
    void findAllUsers() {
    }


    @Test
    void save() throws Exception {
        when(service.saveUpdate(USER_REQUEST_PUT_ID_NULL)).thenReturn(USER_RESPONSE);
        String jsonBody = objectMapper.writeValueAsString(USER_REQUEST_PUT_ID_NULL);
        ResultActions mvc = mockMvc.perform(post(uri)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        mvc.andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should delete and return one message of success")
    void deleteWithSuccess() throws Exception {
        when(service.delete(ID)).thenReturn(anyString());
        ResultActions mvc = mockMvc.perform(delete(uri + "/{id}", ID));

    }

    @Test
    @DisplayName("Should update and return the objects with success")
    void update() throws Exception {
        when(service.saveUpdate(USER_REQUEST_PUT)).thenReturn(USER_RESPONSE);
        String jsonBody = objectMapper.writeValueAsString(USER_REQUEST_PUT);
        ResultActions mvc = mockMvc.perform(put(uri)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        mvc.andExpect(status().isOk());
    }

    @Test
    void changePassowrd() {
    }


}