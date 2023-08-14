package com.users.users.infrastructure.input.rest.auth;

import com.users.users.application.validation.Adult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String lastName;
    private String document;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;
}
