package com.backintro.application.professionalstudy.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

public class ProfessionalStudyNotFoundApplicationException extends ApplicationException {
    public ProfessionalStudyNotFoundApplicationException(ProfessionalStudyId id) {
        super("ProfessionalStudy with id " + id.value() + " was not found.");
    }
}
