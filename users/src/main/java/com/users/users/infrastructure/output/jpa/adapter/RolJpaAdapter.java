package com.users.users.infrastructure.output.jpa.adapter;

import com.users.users.domain.model.Rol;
import com.users.users.domain.spi.IRolPersistencePort;
import com.users.users.infrastructure.output.jpa.mapper.IRolEntityMapper;
import com.users.users.infrastructure.output.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {

    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;



    @Override
    public void saveRol(Rol rol) {
        rolRepository.save(rolEntityMapper.toEntity(rol));
    }

    @Override
    public List<Rol> getAllRoles() {
        return rolEntityMapper.toRolList(rolRepository.findAll());
    }

    @Override
    public Rol getRol(Long rolId) {
        return rolEntityMapper.toRol(rolRepository.findById(rolId).orElseThrow());
    }

    @Override
    public void updateRol(Rol rol) {
        rolRepository.save(rolEntityMapper.toEntity(rol));
    }

    @Override
    public void deleteRol(Long rolId) {
        rolRepository.deleteById(rolId);
    }
}
