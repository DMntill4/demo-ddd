package com.backintro.application.auth.dto;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.entity.Role;

public record UserResponse(
        UUID id,
        String email,
        Set<String> roles,
        boolean active,
        boolean locked,
        UUID professionalId,
        UUID patientId
) {
    public static UserResponse fromDomain(User user) {
        return new UserResponse(
                user.getId().value(),
                user.getEmail().value(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()),
                user.isActive(),
                user.isLocked(),
                user.getProfessionalId(),
                user.getPatientId()
        );
    }
}
