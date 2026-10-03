package com.backintro.domain.treatmentgoal.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public class TreatmentGoalNotFoundException extends DomainException {
    public TreatmentGoalNotFoundException(TreatmentGoalId id) {
        super("TreatmentGoal with id " + id.value() + " was not found.");
    }
}
