package com.backintro.domain.clinicalnote.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public class ClinicalNoteNotFoundException extends DomainException {
    public ClinicalNoteNotFoundException(ClinicalNoteId id) {
        super("ClinicalNote with id " + id.value() + " was not found.");
    }
}
