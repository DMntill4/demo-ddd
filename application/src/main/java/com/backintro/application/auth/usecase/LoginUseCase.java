package com.backintro.application.auth.usecase;

import java.util.Set;
import java.util.stream.Collectors;

import com.backintro.application.auth.command.LoginCommand;
import com.backintro.application.auth.dto.AuthTokenResponse;
import com.backintro.domain.auth.exception.InvalidCredentialsException;
import com.backintro.domain.auth.exception.UserInactiveException;
import com.backintro.domain.auth.exception.UserLockedException;
import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.entity.Role;
import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.port.repository.UserRepository;
import com.backintro.domain.auth.port.security.PasswordHasherPort;
import com.backintro.domain.auth.port.security.TokenProviderPort;

public class LoginUseCase {
    private final UserRepository userRepository;
    private final PasswordHasherPort passwordHasher;
    private final TokenProviderPort tokenProvider;
    private final long tokenExpirationSeconds;

    public LoginUseCase(
            UserRepository userRepository,
            PasswordHasherPort passwordHasher,
            TokenProviderPort tokenProvider,
            long tokenExpirationSeconds
    ) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
        this.tokenProvider = tokenProvider;
        this.tokenExpirationSeconds = tokenExpirationSeconds;
    }

    public AuthTokenResponse execute(LoginCommand command) {
        Email email = Email.of(command.email());
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if (!user.isActive()) {
            throw new UserInactiveException("User account is inactive");
        }

        if (user.isLocked()) {
            throw new UserLockedException("User account is locked due to multiple failed login attempts");
        }

        if (!passwordHasher.matches(command.password(), user.getPasswordHash())) {
            user.recordFailedLogin();
            userRepository.save(user);
            throw new InvalidCredentialsException("Invalid username or password");
        }

        user.resetFailedLogins();
        userRepository.save(user);

        Set<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String accessToken = tokenProvider.generateAccessToken(user.getId().value(), user.getEmail().value(), roles);
        String refreshToken = tokenProvider.generateRefreshToken(user.getId().value(), user.getEmail().value());

        return AuthTokenResponse.of(accessToken, refreshToken, tokenExpirationSeconds, user.getEmail().value(), roles);
    }
}
