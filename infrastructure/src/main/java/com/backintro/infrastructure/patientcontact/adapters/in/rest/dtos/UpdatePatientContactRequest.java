package com.backintro.infrastructure.patientcontact.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdatePatientContactRequest(UUID contactId, UUID patientId, boolean isPrimaryContact, boolean isEmergencyContact, UUID relationshipTypeId) {
}
