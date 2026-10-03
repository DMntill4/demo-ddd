package com.backintro.application.clinicalrecord.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

public class ClinicalRecordNotFoundApplicationException extends ApplicationException {
    public ClinicalRecordNotFoundApplicationException(ClinicalRecordId id) {
        super("ClinicalRecord with id " + id.value() + " was not found.");
    }
}
