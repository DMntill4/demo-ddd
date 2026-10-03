package com.backintro.domain.riskassessment.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public class RiskAssessmentNotFoundException extends DomainException {
    public RiskAssessmentNotFoundException(RiskAssessmentId id) {
        super("RiskAssessment with id " + id.value() + " was not found.");
    }
}
