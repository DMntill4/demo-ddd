package com.backintro.domain.empresa.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EmpresaId(UUID value) {
    public EmpresaId {
        Objects.requireNonNull(value, "id must not be null");
    }

    public static EmpresaId generate() {
        return new EmpresaId(UUID.randomUUID());
    }
}
