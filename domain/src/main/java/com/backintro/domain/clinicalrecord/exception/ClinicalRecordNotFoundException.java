package com.backintro.domain.clinicalrecord.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

public class ClinicalRecordNotFoundException extends DomainException {
    public ClinicalRecordNotFoundException(ClinicalRecordId id) {
        super("ClinicalRecord with id " + id.value() + " was not found.");
    }
}
