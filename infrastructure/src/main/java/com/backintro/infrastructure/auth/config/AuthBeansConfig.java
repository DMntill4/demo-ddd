package com.backintro.infrastructure.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.auth.usecase.LoginUseCase;
import com.backintro.application.auth.usecase.RegisterUserUseCase;
import com.backintro.domain.auth.port.repository.RoleRepository;
import com.backintro.domain.auth.port.repository.UserRepository;
import com.backintro.domain.auth.port.security.PasswordHasherPort;
import com.backintro.domain.auth.port.security.TokenProviderPort;

@Configuration
public class AuthBeansConfig {

    @Bean
    public LoginUseCase loginUseCase(
            UserRepository userRepository,
            PasswordHasherPort passwordHasher,
            TokenProviderPort tokenProvider,
            @Value("${security.jwt.access-expiration-ms:3600000}") long accessExpirationMs
    ) {
        return new LoginUseCase(userRepository, passwordHasher, tokenProvider, accessExpirationMs / 1000);
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordHasherPort passwordHasher
    ) {
        return new RegisterUserUseCase(userRepository, roleRepository, passwordHasher);
    }
}
