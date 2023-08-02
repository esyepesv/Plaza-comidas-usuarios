package com.users.users.application.mapper;

import com.users.users.application.dto.UserResponse;
import com.users.users.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> userList);
}
