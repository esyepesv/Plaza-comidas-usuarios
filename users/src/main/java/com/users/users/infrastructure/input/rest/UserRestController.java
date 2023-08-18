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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;
    Long idRolOwner = 2L;

    @Operation(summary = "Create a new owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Owner created", content = @Content),
    })
    @PostMapping("/create-owner")
    public ResponseEntity<Void> createOwner(@Valid @RequestBody UserRequest userRequest){
        userRequest.setIdRol(idRolOwner);
        userRequest.setRole(Role.OWNER);
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Create a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created", content = @Content),
    })
    @PostMapping("/create-employee")
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody UserRequest userRequest){
        userRequest.setRole(Role.EMPLOYEE);
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Create a new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created", content = @Content),
    })
    @PostMapping("/create-client")
    public ResponseEntity<Void> createClient(@Valid @RequestBody UserRequest userRequest){
        userRequest.setRole(Role.CLIENT);
        userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get a user by id")
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
