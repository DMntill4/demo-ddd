package com.backintro.infrastructure.patient.adapters.in.rest.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record CreatePatientRequest(UUID documentTypeId, String documentNumber, String firstName, String middleName, String lastName, String secondLastName, LocalDate birthDate, UUID biologicalSexId, UUID genderIdentity, String email, String phone, String address, UUID createdBy, UUID updatedBy, UUID cityId) {
}
