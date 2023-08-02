package com.users.users.infrastructure.input.rest;

import com.users.users.application.dto.UserRequest;
import com.users.users.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;


    @PostMapping("/crearPropietario")
    public ResponseEntity<Void> crearPropietario(@RequestBody UserRequest userRequest){
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
