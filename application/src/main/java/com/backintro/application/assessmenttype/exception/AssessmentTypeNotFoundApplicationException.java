package com.backintro.application.assessmenttype.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public class AssessmentTypeNotFoundApplicationException extends ApplicationException {
    public AssessmentTypeNotFoundApplicationException(AssessmentTypeId id) {
        super("AssessmentType with id " + id.value() + " was not found.");
    }
}
