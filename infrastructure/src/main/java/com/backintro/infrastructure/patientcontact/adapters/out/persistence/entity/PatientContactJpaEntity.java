package com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "patient_contacts")
public class PatientContactJpaEntity {
    @Id
    private UUID id;

    @Column(name = "contact_id", nullable = false)
    private UUID contactId;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "is_primary_contact", nullable = false)
    private boolean isPrimaryContact;

    @Column(name = "is_emergency_contact", nullable = false)
    private boolean isEmergencyContact;

    @Column(name = "relationship_type_id")
    private UUID relationshipTypeId;

    public PatientContactJpaEntity() {
    }

    public PatientContactJpaEntity(UUID id, UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
        this.id = id;
        this.contactId = contactId;
        this.patientId = patientId;
        this.isPrimaryContact = isPrimaryContact;
        this.isEmergencyContact = isEmergencyContact;
        this.relationshipTypeId = relationshipTypeId;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getContactId() { return contactId; }
    public void setContactId(UUID contactId) { this.contactId = contactId; }

    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }

    public boolean getIsPrimaryContact() { return isPrimaryContact; }
    public void setIsPrimaryContact(boolean isPrimaryContact) { this.isPrimaryContact = isPrimaryContact; }

    public boolean getIsEmergencyContact() { return isEmergencyContact; }
    public void setIsEmergencyContact(boolean isEmergencyContact) { this.isEmergencyContact = isEmergencyContact; }

    public UUID getRelationshipTypeId() { return relationshipTypeId; }
    public void setRelationshipTypeId(UUID relationshipTypeId) { this.relationshipTypeId = relationshipTypeId; }
}
