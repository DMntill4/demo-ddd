package com.backintro.application.patientallergy.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public class PatientAllergyNotFoundApplicationException extends ApplicationException {
    public PatientAllergyNotFoundApplicationException(PatientAllergyId id) {
        super("PatientAllergy with id " + id.value() + " was not found.");
    }
}
