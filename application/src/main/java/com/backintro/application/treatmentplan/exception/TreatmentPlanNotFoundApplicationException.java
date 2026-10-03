package com.backintro.application.treatmentplan.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public class TreatmentPlanNotFoundApplicationException extends ApplicationException {
    public TreatmentPlanNotFoundApplicationException(TreatmentPlanId id) {
        super("TreatmentPlan with id " + id.value() + " was not found.");
    }
}
