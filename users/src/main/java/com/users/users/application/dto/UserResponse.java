package com.users.users.application.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String phone;
    private String birthDate;
    private String email;
    private String password;
    private Long idRol;
}
