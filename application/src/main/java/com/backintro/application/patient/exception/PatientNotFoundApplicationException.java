package com.backintro.application.patient.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.patient.model.valueobject.PatientId;

public class PatientNotFoundApplicationException extends ApplicationException {
    public PatientNotFoundApplicationException(PatientId id) {
        super("Patient with id " + id.value() + " was not found.");
    }
}
