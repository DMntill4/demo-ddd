package com.backintro.application.clinicalrecordstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public class ClinicalRecordStatusNotFoundApplicationException extends ApplicationException {
    public ClinicalRecordStatusNotFoundApplicationException(ClinicalRecordStatusId id) {
        super("ClinicalRecordStatus with id " + id.value() + " was not found.");
    }
}
