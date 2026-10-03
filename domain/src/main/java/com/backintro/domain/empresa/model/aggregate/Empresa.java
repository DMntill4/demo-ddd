package com.backintro.domain.empresa.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.empresa.event.EmpresaRegisteredEvent;
import com.backintro.domain.empresa.event.EmpresaUpdatedEvent;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;

public class Empresa extends AggregateRoot {
    private final EmpresaId id;
    private String name;
    private String nit;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Empresa(
            EmpresaId id, String name, String nit, String email, String phone, String address, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = name;
        this.nit = nit;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Empresa register(String name, String nit, String email, String phone, String address) {
        EmpresaId id = EmpresaId.generate();
        LocalDateTime now = LocalDateTime.now();
        Empresa aggregate = new Empresa(id, name, nit, email, phone, address, true, now, now);
        aggregate.recordEvent(new EmpresaRegisteredEvent(id, now));
        return aggregate;
    }

    public static Empresa restore(
            EmpresaId id, String name, String nit, String email, String phone, String address, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Empresa(id, name, nit, email, phone, address, active, createdAt, updatedAt);
    }

    public void update(String name, String nit, String email, String phone, String address) {
        this.name = name;
        this.nit = nit;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EmpresaUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public EmpresaId id() { return id; }
    public String name() { return name; }
    public String nit() { return nit; }
    public String email() { return email; }
    public String phone() { return phone; }
    public String address() { return address; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
