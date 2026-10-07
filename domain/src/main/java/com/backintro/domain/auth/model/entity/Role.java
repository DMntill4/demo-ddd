package com.backintro.domain.auth.model.entity;

import java.util.Objects;
import java.util.UUID;

public class Role {
    private final UUID id;
    private final String name;
    private final String description;

    public Role(UUID id, String name, String description) {
        this.id = Objects.requireNonNull(id, "Role id must not be null");
        this.name = Objects.requireNonNull(name, "Role name must not be null");
        this.description = description;
    }

    public static Role of(UUID id, String name, String description) {
        return new Role(id, name, description);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
