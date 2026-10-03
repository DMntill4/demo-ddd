package com.backintro.application.clinicalnote.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public class ClinicalNoteNotFoundApplicationException extends ApplicationException {
    public ClinicalNoteNotFoundApplicationException(ClinicalNoteId id) {
        super("ClinicalNote with id " + id.value() + " was not found.");
    }
}
