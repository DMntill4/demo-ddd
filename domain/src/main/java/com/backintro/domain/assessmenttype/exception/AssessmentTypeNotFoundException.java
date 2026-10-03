package com.backintro.domain.assessmenttype.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public class AssessmentTypeNotFoundException extends DomainException {
    public AssessmentTypeNotFoundException(AssessmentTypeId id) {
        super("AssessmentType with id " + id.value() + " was not found.");
    }
}
