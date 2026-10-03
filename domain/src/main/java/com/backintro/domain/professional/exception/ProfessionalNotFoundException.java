package com.backintro.domain.professional.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public class ProfessionalNotFoundException extends DomainException {
    public ProfessionalNotFoundException(ProfessionalId id) {
        super("Professional with id " + id.value() + " was not found.");
    }
}
