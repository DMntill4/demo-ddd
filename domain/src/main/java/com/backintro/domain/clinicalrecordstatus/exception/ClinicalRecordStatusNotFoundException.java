package com.backintro.domain.clinicalrecordstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public class ClinicalRecordStatusNotFoundException extends DomainException {
    public ClinicalRecordStatusNotFoundException(ClinicalRecordStatusId id) {
        super("ClinicalRecordStatus with id " + id.value() + " was not found.");
    }
}
