package com.users.users.domain.usecase;

import com.users.users.domain.api.IRolServicePort;
import com.users.users.domain.model.Rol;
import com.users.users.domain.spi.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    private final IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public void saveRol(Rol rol) {
        rolPersistencePort.saveRol(rol);
    }

    @Override
    public List<Rol> getAllRoles() {
        return rolPersistencePort.getAllRoles();
    }

    @Override
    public Rol getRol(Long rolId) {
        return rolPersistencePort.getRol(rolId);
    }

    @Override
    public void updateRol(Rol rol) {
        rolPersistencePort.updateRol(rol);
    }

    @Override
    public void deleteRol(Long rolId) {
        rolPersistencePort.deleteRol(rolId);
    }
}
