package com.backintro.application.auth.usecase;

import java.util.HashSet;
import java.util.Set;

import com.backintro.application.auth.command.RegisterUserCommand;
import com.backintro.application.auth.dto.UserResponse;
import com.backintro.domain.auth.exception.UserAlreadyExistsException;
import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.entity.Role;
import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.model.valueobject.PasswordHash;
import com.backintro.domain.auth.port.repository.RoleRepository;
import com.backintro.domain.auth.port.repository.UserRepository;
import com.backintro.domain.auth.port.security.PasswordHasherPort;

public class RegisterUserUseCase {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordHasherPort passwordHasher;

    public RegisterUserUseCase(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordHasherPort passwordHasher
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordHasher = passwordHasher;
    }

    public UserResponse execute(RegisterUserCommand command) {
        Email email = Email.of(command.email());

        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("User with email " + command.email() + " already exists");
        }

        PasswordHash passwordHash = passwordHasher.hash(command.password());

        Set<Role> roles = new HashSet<>();
        if (command.roleNames() != null && !command.roleNames().isEmpty()) {
            for (String roleName : command.roleNames()) {
                roleRepository.findByName(roleName).ifPresent(roles::add);
            }
        }

        // Si no se especificó rol, se asigna ROLE_PATIENT por defecto
        if (roles.isEmpty()) {
            roleRepository.findByName("ROLE_PATIENT").ifPresent(roles::add);
        }

        User user = User.create(
                email,
                passwordHash,
                roles,
                command.professionalId(),
                command.patientId()
        );

        User savedUser = userRepository.save(user);
        return UserResponse.fromDomain(savedUser);
    }
}
