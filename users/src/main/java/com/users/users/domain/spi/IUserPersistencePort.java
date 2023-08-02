package com.users.users.domain.spi;

import com.users.users.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    void saveUser(User user);

    List<User> getAllUsers();

    User getUser(Long userId);

    void updateUser(User user);

    void deleteUser(Long userId);
}
