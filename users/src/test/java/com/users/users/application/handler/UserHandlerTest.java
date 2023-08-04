package com.users.users.application.handler;

import com.users.users.application.dto.UserRequest;
import com.users.users.application.mapper.UserRequestMapper;
import com.users.users.domain.api.IRolServicePort;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserHandlerTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IRolServicePort rolServicePort;

    @Mock
    private UserRequestMapper userRequestMapper;

    @InjectMocks
    private UserHandler userHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() {
        // Given
        UserRequest userRequest = new UserRequest();
        userRequest.setName("John");
        userRequest.setLastName("Doe");
        userRequest.setDocument("123456789");
        userRequest.setPhone("+1234567890");
        userRequest.setBirthDate(LocalDate.of(1990, 1, 1));
        userRequest.setEmail("johndoe@example.com");
        userRequest.setPassword("password");
        userRequest.setIdRol(1L);

        User user = new User();
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setDocument(userRequest.getDocument());
        user.setPhone(userRequest.getPhone());
        user.setBirthDate(userRequest.getBirthDate());
        user.setEmail(userRequest.getEmail());
        user.setPassword(BCrypt.hashpw(userRequest.getPassword(), BCrypt.gensalt()));
        user.setIdRol(userRequest.getIdRol());

        when(userRequestMapper.toUser(userRequest)).thenReturn(user);

        userHandler.saveUser(userRequest);

        assertEquals(user.getName(), userRequest.getName());
        assertEquals(user.getLastName(), userRequest.getLastName());
        assertEquals(user.getDocument(), userRequest.getDocument());
        assertEquals(user.getPhone(), userRequest.getPhone());
        assertEquals(user.getBirthDate(), userRequest.getBirthDate());
        assertEquals(user.getEmail(), userRequest.getEmail());
        assertEquals(user.getIdRol(), userRequest.getIdRol());
    }
}
