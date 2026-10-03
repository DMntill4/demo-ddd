package com.backintro.application.professionaltype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;

public class ProfessionalTypeNotFoundApplicationException extends ApplicationException {
    public ProfessionalTypeNotFoundApplicationException(ProfessionalTypeId id) {
        super("ProfessionalType with id " + id.value() + " was not found.");
    }
}
