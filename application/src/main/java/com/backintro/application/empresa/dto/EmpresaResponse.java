package com.backintro.application.empresa.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.empresa.model.aggregate.Empresa;

public record EmpresaResponse(UUID id, String name, String nit, String email, String phone, String address, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static EmpresaResponse fromDomain(Empresa aggregate) {
        return new EmpresaResponse(aggregate.id().value(), aggregate.name(), aggregate.nit(), aggregate.email(), aggregate.phone(), aggregate.address(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }
}
