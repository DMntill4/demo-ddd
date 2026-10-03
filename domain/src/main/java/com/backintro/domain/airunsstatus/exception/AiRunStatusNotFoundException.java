package com.backintro.domain.airunsstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;

public class AiRunStatusNotFoundException extends DomainException {
    public AiRunStatusNotFoundException(AiRunStatusId id) {
        super("AiRunStatus with id " + id.value() + " was not found.");
    }
}
