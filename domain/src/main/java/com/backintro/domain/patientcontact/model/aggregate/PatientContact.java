package com.backintro.domain.patientcontact.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.patientcontact.event.PatientContactRegisteredEvent;
import com.backintro.domain.patientcontact.event.PatientContactUpdatedEvent;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public class PatientContact extends AggregateRoot {
    private final PatientContactId id;
    private UUID contactId;
    private UUID patientId;
    private boolean isPrimaryContact;
    private boolean isEmergencyContact;
    private UUID relationshipTypeId;

    private PatientContact(
            PatientContactId id, UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = contactId;
        this.patientId = patientId;
        this.isPrimaryContact = isPrimaryContact;
        this.isEmergencyContact = isEmergencyContact;
        this.relationshipTypeId = relationshipTypeId;
    }

    public static PatientContact register(UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
        PatientContactId id = PatientContactId.generate();
        LocalDateTime now = LocalDateTime.now();
        PatientContact aggregate = new PatientContact(id, contactId, patientId, isPrimaryContact, isEmergencyContact, relationshipTypeId);
        aggregate.recordEvent(new PatientContactRegisteredEvent(id, now));
        return aggregate;
    }

    public static PatientContact restore(
            PatientContactId id, UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
        return new PatientContact(id, contactId, patientId, isPrimaryContact, isEmergencyContact, relationshipTypeId);
    }

    public void update(UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
        this.contactId = contactId;
        this.patientId = patientId;
        this.isPrimaryContact = isPrimaryContact;
        this.isEmergencyContact = isEmergencyContact;
        this.relationshipTypeId = relationshipTypeId;
        recordEvent(new PatientContactUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public PatientContactId id() { return id; }
    public UUID contactId() { return contactId; }
    public UUID patientId() { return patientId; }
    public boolean isPrimaryContact() { return isPrimaryContact; }
    public boolean isEmergencyContact() { return isEmergencyContact; }
    public UUID relationshipTypeId() { return relationshipTypeId; }
}
