package com.backintro.domain.contact.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.contact.event.ContactRegisteredEvent;
import com.backintro.domain.contact.event.ContactUpdatedEvent;
import com.backintro.domain.contact.model.valueobject.ContactId;

public class Contact extends AggregateRoot {
    private final ContactId id;
    private String fullName;
    private String email;
    private String notes;
    private UUID cityId;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;

    private Contact(
            ContactId id, String fullName, String email, String notes, UUID cityId, LocalDateTime createdAt, UUID createdBy, LocalDateTime updatedAt, UUID updatedBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = cityId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public static Contact register(String fullName, String email, String notes, UUID cityId, UUID createdBy, UUID updatedBy) {
        ContactId id = ContactId.generate();
        LocalDateTime now = LocalDateTime.now();
        Contact aggregate = new Contact(id, fullName, email, notes, cityId, now, createdBy, now, updatedBy);
        aggregate.recordEvent(new ContactRegisteredEvent(id, now));
        return aggregate;
    }

    public static Contact restore(
            ContactId id, String fullName, String email, String notes, UUID cityId, LocalDateTime createdAt, UUID createdBy, LocalDateTime updatedAt, UUID updatedBy) {
        return new Contact(id, fullName, email, notes, cityId, createdAt, createdBy, updatedAt, updatedBy);
    }

    public void update(String fullName, String email, String notes, UUID cityId, UUID createdBy, UUID updatedBy) {
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = cityId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ContactUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ContactId id() { return id; }
    public String fullName() { return fullName; }
    public String email() { return email; }
    public String notes() { return notes; }
    public UUID cityId() { return cityId; }
    public LocalDateTime createdAt() { return createdAt; }
    public UUID createdBy() { return createdBy; }
    public LocalDateTime updatedAt() { return updatedAt; }
    public UUID updatedBy() { return updatedBy; }
}
