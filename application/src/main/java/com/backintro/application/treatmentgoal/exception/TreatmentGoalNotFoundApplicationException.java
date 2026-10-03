package com.backintro.application.treatmentgoal.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public class TreatmentGoalNotFoundApplicationException extends ApplicationException {
    public TreatmentGoalNotFoundApplicationException(TreatmentGoalId id) {
        super("TreatmentGoal with id " + id.value() + " was not found.");
    }
}
