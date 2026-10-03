package com.backintro.application.airunsstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;

public class AiRunStatusNotFoundApplicationException extends ApplicationException {
    public AiRunStatusNotFoundApplicationException(AiRunStatusId id) {
        super("AiRunStatus with id " + id.value() + " was not found.");
    }
}
