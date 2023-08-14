package com.users.users.infrastructure.input.rest;

import com.users.users.application.dto.UserRequest;
import com.users.users.application.dto.UserResponse;
import com.users.users.application.handler.IUserHandler;
import com.users.users.domain.model.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;


    @Operation(summary = "/usuarios/crearPropietario", description = "creacion de usuarios propietarios")

    @PostMapping("/crearPropietario")
    public ResponseEntity<Void> crearPropietario(@Valid @RequestBody UserRequest userRequest){
        userRequest.setIdRol(2L);
        userRequest.setRole(Role.OWNER);
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "obtener un usuario por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
        UserResponse userResponse = userHandler.getUser(userId);

        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
