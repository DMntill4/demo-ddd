package com.backintro.domain.professional.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.professional.event.ProfessionalRegisteredEvent;
import com.backintro.domain.professional.event.ProfessionalUpdatedEvent;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public class Professional extends AggregateRoot {
    private final ProfessionalId id;
    private UUID documentTypeId;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private UUID professionalTypeId;
    private String licenseNumber;
    private boolean active;
    private UUID cityId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Professional(
            ProfessionalId id, UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, boolean active, UUID cityId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalTypeId = professionalTypeId;
        this.licenseNumber = licenseNumber;
        this.active = active;
        this.cityId = cityId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Professional register(UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, UUID cityId) {
        ProfessionalId id = ProfessionalId.generate();
        LocalDateTime now = LocalDateTime.now();
        Professional aggregate = new Professional(id, documentTypeId, documentNumber, firstName, lastName, professionalTypeId, licenseNumber, true, cityId, now, now);
        aggregate.recordEvent(new ProfessionalRegisteredEvent(id, now));
        return aggregate;
    }

    public static Professional restore(
            ProfessionalId id, UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, boolean active, UUID cityId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Professional(id, documentTypeId, documentNumber, firstName, lastName, professionalTypeId, licenseNumber, active, cityId, createdAt, updatedAt);
    }

    public void update(UUID documentTypeId, String documentNumber, String firstName, String lastName, UUID professionalTypeId, String licenseNumber, UUID cityId) {
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalTypeId = professionalTypeId;
        this.licenseNumber = licenseNumber;
        this.cityId = cityId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ProfessionalUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ProfessionalId id() { return id; }
    public UUID documentTypeId() { return documentTypeId; }
    public String documentNumber() { return documentNumber; }
    public String firstName() { return firstName; }
    public String lastName() { return lastName; }
    public UUID professionalTypeId() { return professionalTypeId; }
    public String licenseNumber() { return licenseNumber; }
    public boolean active() { return active; }
    public UUID cityId() { return cityId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
