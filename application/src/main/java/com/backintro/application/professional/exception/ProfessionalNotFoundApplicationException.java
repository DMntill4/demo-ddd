package com.backintro.application.professional.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public class ProfessionalNotFoundApplicationException extends ApplicationException {
    public ProfessionalNotFoundApplicationException(ProfessionalId id) {
        super("Professional with id " + id.value() + " was not found.");
    }
}
