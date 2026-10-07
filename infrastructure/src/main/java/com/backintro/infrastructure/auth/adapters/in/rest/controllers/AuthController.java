package com.backintro.infrastructure.auth.adapters.in.rest.controllers;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backintro.application.auth.command.LoginCommand;
import com.backintro.application.auth.command.RegisterUserCommand;
import com.backintro.application.auth.dto.AuthTokenResponse;
import com.backintro.application.auth.dto.UserResponse;
import com.backintro.application.auth.usecase.LoginUseCase;
import com.backintro.application.auth.usecase.RegisterUserUseCase;
import com.backintro.infrastructure.auth.adapters.in.rest.dtos.LoginRequest;
import com.backintro.infrastructure.auth.adapters.in.rest.dtos.RegisterRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    public AuthController(LoginUseCase loginUseCase, RegisterUserUseCase registerUserUseCase) {
        this.loginUseCase = loginUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginCommand command = new LoginCommand(request.email(), request.password());
        AuthTokenResponse response = loginUseCase.execute(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        RegisterUserCommand command = new RegisterUserCommand(
                request.email(),
                request.password(),
                request.roles(),
                request.professionalId(),
                request.patientId()
        );
        UserResponse response = registerUserUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
