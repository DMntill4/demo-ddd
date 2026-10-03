package com.backintro.domain.professionalstudy.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

public class ProfessionalStudyNotFoundException extends DomainException {
    public ProfessionalStudyNotFoundException(ProfessionalStudyId id) {
        super("ProfessionalStudy with id " + id.value() + " was not found.");
    }
}
