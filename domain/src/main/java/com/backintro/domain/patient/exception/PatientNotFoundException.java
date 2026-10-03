package com.backintro.domain.patient.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.patient.model.valueobject.PatientId;

public class PatientNotFoundException extends DomainException {
    public PatientNotFoundException(PatientId id) {
        super("Patient with id " + id.value() + " was not found.");
    }
}
