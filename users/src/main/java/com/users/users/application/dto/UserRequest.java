package com.users.users.application.dto;

import com.users.users.application.validation.Adult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String lastName;
    @Pattern(regexp = "^[0-9]+$")
    private String document;
    @Pattern(regexp = "\\+?[0-9]{10,13}")
    private String phone;
    @Adult
    private LocalDate birthDate;
    @Email
    private String email;
    private String password;
    private Long idRol;
}
