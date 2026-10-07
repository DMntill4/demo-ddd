package com.backintro.application.auth.command;

import java.util.Set;
import java.util.UUID;

public record RegisterUserCommand(
        String email,
        String password,
        Set<String> roleNames,
        UUID professionalId,
        UUID patientId
) {}
