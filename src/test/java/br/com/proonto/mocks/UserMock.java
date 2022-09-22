package br.com.proonto.mocks;

import br.com.proonto.models.entities.Permission;
import br.com.proonto.models.entities.User;
import br.com.proonto.models.requests.ChangePasswordRequest;
import br.com.proonto.models.requests.UserRequestPost;
import br.com.proonto.models.requests.UserRequestPut;
import br.com.proonto.models.responses.UserResponse;

import java.util.ArrayList;
import java.util.List;

import static br.com.proonto.mocks.MessageMock.*;

public interface UserMock {
    public static final String USER_NAME = "junior";
    public static final String PASSWORD = "123456";
    public static final String CPF = "882.885.954-00";
    public static final List<Permission> PERMISSION_LIST = new ArrayList<>();
    public static final User USER_ENTITY = new User(ID, USER_NAME, EMAIL, PASSWORD, true, CPF, CREATED_AT, UPDATED_AT, PERMISSION_LIST);
    public static final UserRequestPost USER_REQUEST_POST = new UserRequestPost(USER_NAME, EMAIL, PASSWORD, CPF, true, CREATED_AT, PERMISSION_LIST);
    public static final UserRequestPut USER_REQUEST_PUT = new UserRequestPut(ID, USER_NAME, EMAIL, PASSWORD, CPF, true, PERMISSION_LIST, UPDATED_AT);
    public static final UserRequestPut USER_REQUEST_PUT_ID_NULL = new UserRequestPut(null, USER_NAME, EMAIL, PASSWORD, CPF, true, PERMISSION_LIST, UPDATED_AT);
    public static final UserResponse USER_RESPONSE = new UserResponse(ID, USER_NAME, EMAIL, true, CPF,CREATED_AT, UPDATED_AT, PERMISSION_LIST);
    public static final ChangePasswordRequest CHANGE_PASSWORD_REQUEST = new ChangePasswordRequest(ID, PASSWORD);
}
