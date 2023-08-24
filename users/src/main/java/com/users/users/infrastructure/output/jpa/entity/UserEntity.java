package com.users.users.infrastructure.output.jpa.entity;


import com.users.users.domain.model.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String phone;
    private String birthDate;
    private String email;
    private String password;
    private Long idRol;
    @Enumerated(EnumType.STRING)
    private Role role;

}
