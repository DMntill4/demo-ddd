package com.backintro.application.medicationroute.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public class MedicationRouteNotFoundApplicationException extends ApplicationException {
    public MedicationRouteNotFoundApplicationException(MedicationRouteId id) {
        super("MedicationRoute with id " + id.value() + " was not found.");
    }
}
