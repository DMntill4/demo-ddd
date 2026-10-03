package com.backintro.application.patientcontact.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public class PatientContactNotFoundApplicationException extends ApplicationException {
    public PatientContactNotFoundApplicationException(PatientContactId id) {
        super("PatientContact with id " + id.value() + " was not found.");
    }
}
