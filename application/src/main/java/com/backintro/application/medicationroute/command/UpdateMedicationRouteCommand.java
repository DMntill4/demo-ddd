package com.backintro.application.medicationroute.command;

import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public record UpdateMedicationRouteCommand(MedicationRouteId id, String code, String name) {
}
