package com.backintro.domain.treatmentplan.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public class TreatmentPlanNotFoundException extends DomainException {
    public TreatmentPlanNotFoundException(TreatmentPlanId id) {
        super("TreatmentPlan with id " + id.value() + " was not found.");
    }
}
