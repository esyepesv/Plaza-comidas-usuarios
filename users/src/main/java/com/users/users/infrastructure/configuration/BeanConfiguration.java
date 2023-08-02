package com.users.users.infrastructure.configuration;

import com.users.users.domain.api.IRolServicePort;
import com.users.users.domain.api.IUserServicePort;
import com.users.users.domain.spi.IRolPersistencePort;
import com.users.users.domain.spi.IUserPersistencePort;
import com.users.users.domain.usecase.RolUseCase;
import com.users.users.domain.usecase.UserUseCase;
import com.users.users.infrastructure.output.jpa.adapter.RolJpaAdapter;
import com.users.users.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.users.users.infrastructure.output.jpa.mapper.IRolEntityMapper;
import com.users.users.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.users.users.infrastructure.output.jpa.repository.IRolRepository;
import com.users.users.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    public final IUserRepository userRepository;
    public final IUserEntityMapper userEntityMapper;
    public final IRolRepository rolRepository;
    public final IRolEntityMapper rolEntityMapper;


    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IRolPersistencePort rolPersistencePort(){
        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRolServicePort rolServicePort(){
        return new RolUseCase(rolPersistencePort());
    }


}
