package com.backintro.domain.study.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.study.model.valueobject.StudyId;

public class StudyNotFoundException extends DomainException {
    public StudyNotFoundException(StudyId id) {
        super("Study with id " + id.value() + " was not found.");
    }
}
