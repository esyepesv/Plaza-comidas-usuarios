package com.users.users.application.handler;

import com.users.users.application.dto.UserRequest;
import com.users.users.application.dto.UserResponse;

public interface IUserHandler {
    void saveUser(UserRequest userRequest);
    UserResponse getUser(Long userId);

}
