package com.backintro.domain.treatmentstatuss.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;

public class TreatmentStatusNotFoundException extends DomainException {
    public TreatmentStatusNotFoundException(TreatmentStatusId id) {
        super("TreatmentStatus with id " + id.value() + " was not found.");
    }
}
