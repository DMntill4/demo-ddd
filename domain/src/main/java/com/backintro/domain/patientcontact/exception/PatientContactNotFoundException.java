package com.backintro.domain.patientcontact.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public class PatientContactNotFoundException extends DomainException {
    public PatientContactNotFoundException(PatientContactId id) {
        super("PatientContact with id " + id.value() + " was not found.");
    }
}
