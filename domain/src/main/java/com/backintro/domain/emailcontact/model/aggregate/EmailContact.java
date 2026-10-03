package com.backintro.domain.emailcontact.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.emailcontact.event.EmailContactRegisteredEvent;
import com.backintro.domain.emailcontact.event.EmailContactUpdatedEvent;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public class EmailContact extends AggregateRoot {
    private final EmailContactId id;
    private UUID contactId;
    private String email;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EmailContact(
            EmailContactId id, UUID contactId, String email, String notes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = contactId;
        this.email = email;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static EmailContact register(UUID contactId, String email, String notes) {
        EmailContactId id = EmailContactId.generate();
        LocalDateTime now = LocalDateTime.now();
        EmailContact aggregate = new EmailContact(id, contactId, email, notes, now, now);
        aggregate.recordEvent(new EmailContactRegisteredEvent(id, now));
        return aggregate;
    }

    public static EmailContact restore(
            EmailContactId id, UUID contactId, String email, String notes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EmailContact(id, contactId, email, notes, createdAt, updatedAt);
    }

    public void update(UUID contactId, String email, String notes) {
        this.contactId = contactId;
        this.email = email;
        this.notes = notes;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new EmailContactUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public EmailContactId id() { return id; }
    public UUID contactId() { return contactId; }
    public String email() { return email; }
    public String notes() { return notes; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
