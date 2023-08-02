package com.users.users.application.handler;

import com.users.users.application.dto.UserRequest;
import com.users.users.application.mapper.UserRequestMapper;
import com.users.users.domain.api.IRolServicePort;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final IRolServicePort rolServicePort;
    private final UserRequestMapper userRequestMapper;


    @Override
    public void saveUser(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.saveUser(user);
    }
}
