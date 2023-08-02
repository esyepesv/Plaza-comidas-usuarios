package com.users.users.application.handler;

import com.users.users.application.dto.UserRequest;

public interface IUserHandler {
    void saveUser(UserRequest userRequest);
}
