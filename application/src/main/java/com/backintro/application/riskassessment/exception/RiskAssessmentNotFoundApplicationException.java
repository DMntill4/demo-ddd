package com.backintro.application.riskassessment.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public class RiskAssessmentNotFoundApplicationException extends ApplicationException {
    public RiskAssessmentNotFoundApplicationException(RiskAssessmentId id) {
        super("RiskAssessment with id " + id.value() + " was not found.");
    }
}
