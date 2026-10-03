package com.backintro.domain.professionaltype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;

public class ProfessionalTypeNotFoundException extends DomainException {
    public ProfessionalTypeNotFoundException(ProfessionalTypeId id) {
        super("ProfessionalType with id " + id.value() + " was not found.");
    }
}
