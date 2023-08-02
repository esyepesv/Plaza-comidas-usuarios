package com.users.users.domain.api;

import com.users.users.domain.model.Rol;

import java.util.List;

public interface IRolServicePort {

    void saveRol(Rol rol);

    List<Rol> getAllRoles();

    Rol getRol(Long rolId);

    void updateRol(Rol rol);

    void deleteRol(Long rolId);
}
