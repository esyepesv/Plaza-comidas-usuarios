package com.users.users.infrastructure.output.jpa.mapper;

import com.users.users.domain.model.Rol;
import com.users.users.infrastructure.output.jpa.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolEntityMapper {
    RolEntity toEntity(Rol rol);

    Rol toRol(RolEntity rolEntity);

    List<Rol> toRolList(List<RolEntity> rolEntityList);
}
