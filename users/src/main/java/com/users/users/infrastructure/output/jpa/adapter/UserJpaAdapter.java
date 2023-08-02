package com.users.users.infrastructure.output.jpa.adapter;

import com.users.users.domain.model.User;
import com.users.users.domain.spi.IUserPersistencePort;
import com.users.users.infrastructure.exception.NoDataFoundException;
import com.users.users.infrastructure.exception.UserNotFoundException;
import com.users.users.infrastructure.output.jpa.entity.UserEntity;
import com.users.users.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.users.users.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;



    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        if (userEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public User getUser(Long userId) {
        return userEntityMapper.toUser(userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new));
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
