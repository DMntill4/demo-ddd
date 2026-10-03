package com.backintro.application.treatmentstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

public class TreatmentStatusNotFoundApplicationException extends ApplicationException {
    public TreatmentStatusNotFoundApplicationException(TreatmentStatusId id) {
        super("TreatmentStatus with id " + id.value() + " was not found.");
    }
}
