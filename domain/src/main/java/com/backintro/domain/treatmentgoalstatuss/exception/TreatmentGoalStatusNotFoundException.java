package com.backintro.domain.treatmentgoalstatuss.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;

public class TreatmentGoalStatusNotFoundException extends DomainException {
    public TreatmentGoalStatusNotFoundException(TreatmentGoalStatusId id) {
        super("TreatmentGoalStatus with id " + id.value() + " was not found.");
    }
}
