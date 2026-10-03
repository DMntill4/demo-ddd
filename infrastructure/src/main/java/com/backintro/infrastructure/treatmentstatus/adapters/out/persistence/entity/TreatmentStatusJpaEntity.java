package com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "treatment_statusses")
public class TreatmentStatusJpaEntity {
    @Id
    private UUID id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 10)
    private String code;

    @Column(nullable = false)
    private boolean active;

    public TreatmentStatusJpaEntity() {
    }

    public TreatmentStatusJpaEntity(UUID id, String name, String code, boolean active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
