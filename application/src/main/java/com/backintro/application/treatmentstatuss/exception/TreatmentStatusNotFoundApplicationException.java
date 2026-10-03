package com.backintro.application.treatmentstatuss.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;

public class TreatmentStatusNotFoundApplicationException extends ApplicationException {
    public TreatmentStatusNotFoundApplicationException(TreatmentStatusId id) {
        super("TreatmentStatus with id " + id.value() + " was not found.");
    }
}
