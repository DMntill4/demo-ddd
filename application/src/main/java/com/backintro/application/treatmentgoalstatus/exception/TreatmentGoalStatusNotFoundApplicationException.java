package com.backintro.application.treatmentgoalstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

public class TreatmentGoalStatusNotFoundApplicationException extends ApplicationException {
    public TreatmentGoalStatusNotFoundApplicationException(TreatmentGoalStatusId id) {
        super("TreatmentGoalStatus with id " + id.value() + " was not found.");
    }
}
