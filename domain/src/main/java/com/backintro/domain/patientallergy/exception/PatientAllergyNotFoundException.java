package com.backintro.domain.patientallergy.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public class PatientAllergyNotFoundException extends DomainException {
    public PatientAllergyNotFoundException(PatientAllergyId id) {
        super("PatientAllergy with id " + id.value() + " was not found.");
    }
}
