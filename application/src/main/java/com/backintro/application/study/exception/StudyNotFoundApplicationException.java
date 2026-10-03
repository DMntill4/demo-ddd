package com.backintro.application.study.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.study.model.valueobject.StudyId;

public class StudyNotFoundApplicationException extends ApplicationException {
    public StudyNotFoundApplicationException(StudyId id) {
        super("Study with id " + id.value() + " was not found.");
    }
}
