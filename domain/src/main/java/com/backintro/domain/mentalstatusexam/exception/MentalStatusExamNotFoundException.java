package com.backintro.domain.mentalstatusexam.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

public class MentalStatusExamNotFoundException extends DomainException {
    public MentalStatusExamNotFoundException(MentalStatusExamId id) {
        super("MentalStatusExam with id " + id.value() + " was not found.");
    }
}
