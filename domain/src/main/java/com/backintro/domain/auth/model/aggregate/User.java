package com.backintro.domain.auth.model.aggregate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.backintro.domain.auth.model.entity.Role;
import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.model.valueobject.PasswordHash;
import com.backintro.domain.auth.model.valueobject.UserId;
import com.backintro.domain.common.model.AggregateRoot;

public class User extends AggregateRoot {
    private final UserId id;
    private Email email;
    private PasswordHash passwordHash;
    private final Set<Role> roles;
    private boolean active;
    private boolean locked;
    private int failedAttempts;
    private UUID professionalId;
    private UUID patientId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private User(
            UserId id,
            Email email,
            PasswordHash passwordHash,
            Set<Role> roles,
            boolean active,
            boolean locked,
            int failedAttempts,
            UUID professionalId,
            UUID patientId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = Objects.requireNonNull(id, "UserId must not be null");
        this.email = Objects.requireNonNull(email, "Email must not be null");
        this.passwordHash = Objects.requireNonNull(passwordHash, "PasswordHash must not be null");
        this.roles = new HashSet<>(roles != null ? roles : Collections.emptySet());
        this.active = active;
        this.locked = locked;
        this.failedAttempts = failedAttempts;
        this.professionalId = professionalId;
        this.patientId = patientId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static User create(
            Email email,
            PasswordHash passwordHash,
            Set<Role> roles,
            UUID professionalId,
            UUID patientId
    ) {
        UserId id = UserId.generate();
        LocalDateTime now = LocalDateTime.now();
        return new User(id, email, passwordHash, roles, true, false, 0, professionalId, patientId, now, now);
    }

    public static User restore(
            UserId id,
            Email email,
            PasswordHash passwordHash,
            Set<Role> roles,
            boolean active,
            boolean locked,
            int failedAttempts,
            UUID professionalId,
            UUID patientId,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new User(id, email, passwordHash, roles, active, locked, failedAttempts, professionalId, patientId, createdAt, updatedAt);
    }

    public void recordFailedLogin() {
        this.failedAttempts++;
        if (this.failedAttempts >= 5) {
            this.locked = true;
        }
        this.updatedAt = LocalDateTime.now();
    }

    public void resetFailedLogins() {
        this.failedAttempts = 0;
        this.updatedAt = LocalDateTime.now();
    }

    public void changePassword(PasswordHash newPasswordHash) {
        this.passwordHash = Objects.requireNonNull(newPasswordHash, "New password hash must not be null");
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        this.active = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void activate() {
        this.active = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void unlock() {
        this.locked = false;
        this.failedAttempts = 0;
        this.updatedAt = LocalDateTime.now();
    }

    public void assignRole(Role role) {
        if (role != null) {
            this.roles.add(role);
            this.updatedAt = LocalDateTime.now();
        }
    }

    public UserId getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public PasswordHash getPasswordHash() {
        return passwordHash;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public boolean isActive() {
        return active;
    }

    public boolean isLocked() {
        return locked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public UUID getProfessionalId() {
        return professionalId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
