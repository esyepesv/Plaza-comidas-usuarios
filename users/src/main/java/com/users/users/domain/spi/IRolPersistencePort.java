package com.users.users.domain.spi;

import com.users.users.domain.model.Rol;

import java.util.List;

public interface IRolPersistencePort {
    void saveRol(Rol rol);

    List<Rol> getAllRoles();

    Rol getRol(Long rolId);

    void updateRol(Rol rol);

    void deleteRol(Long rolId);
}
