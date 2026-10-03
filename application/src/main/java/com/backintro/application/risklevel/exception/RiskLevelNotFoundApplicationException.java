package com.backintro.application.risklevel.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public class RiskLevelNotFoundApplicationException extends ApplicationException {
    public RiskLevelNotFoundApplicationException(RiskLevelId id) {
        super("RiskLevel with id " + id.value() + " was not found.");
    }
}
