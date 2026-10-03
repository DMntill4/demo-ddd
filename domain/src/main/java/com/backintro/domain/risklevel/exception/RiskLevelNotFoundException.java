package com.backintro.domain.risklevel.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public class RiskLevelNotFoundException extends DomainException {
    public RiskLevelNotFoundException(RiskLevelId id) {
        super("RiskLevel with id " + id.value() + " was not found.");
    }
}
