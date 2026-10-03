package com.backintro.application.patientcontact.command;

import java.util.UUID;

import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public record UpdatePatientContactCommand(PatientContactId id, UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
}
