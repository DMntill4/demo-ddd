package com.backintro.application.mentalstatusexam.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

public class MentalStatusExamNotFoundApplicationException extends ApplicationException {
    public MentalStatusExamNotFoundApplicationException(MentalStatusExamId id) {
        super("MentalStatusExam with id " + id.value() + " was not found.");
    }
}
