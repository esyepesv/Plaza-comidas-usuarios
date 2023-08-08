package com.users.users.application.handler;

import com.users.users.application.dto.UserRequest;
import com.users.users.application.dto.UserResponse;
import com.users.users.application.mapper.UserRequestMapper;
import com.users.users.application.mapper.UserResponseMapper;
import com.users.users.domain.api.IRolServicePort;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.model.Rol;
import com.users.users.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final IRolServicePort rolServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;


    @Override
    public void saveUser(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userServicePort.saveUser(user);
    }

    @Override
    public UserResponse getUser(Long userId) {
        User user = userServicePort.getUser(userId);
        //Rol rol = rolServicePort.getRol(user.getIdRol());
        return userResponseMapper.toResponse(user);
    }
}
