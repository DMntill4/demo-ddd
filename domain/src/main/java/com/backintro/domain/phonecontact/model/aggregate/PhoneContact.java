package com.backintro.domain.phonecontact.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.phonecontact.event.PhoneContactRegisteredEvent;
import com.backintro.domain.phonecontact.event.PhoneContactUpdatedEvent;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;

public class PhoneContact extends AggregateRoot {
    private final PhoneContactId id;
    private UUID contactId;
    private String phone;
    private String notes;

    private PhoneContact(
            PhoneContactId id, UUID contactId, String phone, String notes) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = contactId;
        this.phone = phone;
        this.notes = notes;
    }

    public static PhoneContact register(UUID contactId, String phone, String notes) {
        PhoneContactId id = PhoneContactId.generate();
        LocalDateTime now = LocalDateTime.now();
        PhoneContact aggregate = new PhoneContact(id, contactId, phone, notes);
        aggregate.recordEvent(new PhoneContactRegisteredEvent(id, now));
        return aggregate;
    }

    public static PhoneContact restore(
            PhoneContactId id, UUID contactId, String phone, String notes) {
        return new PhoneContact(id, contactId, phone, notes);
    }

    public void update(UUID contactId, String phone, String notes) {
        this.contactId = contactId;
        this.phone = phone;
        this.notes = notes;
        recordEvent(new PhoneContactUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public PhoneContactId id() { return id; }
    public UUID contactId() { return contactId; }
    public String phone() { return phone; }
    public String notes() { return notes; }
}
