package com.backintro.domain.medicationroute.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public class MedicationRouteNotFoundException extends DomainException {
    public MedicationRouteNotFoundException(MedicationRouteId id) {
        super("MedicationRoute with id " + id.value() + " was not found.");
    }
}
