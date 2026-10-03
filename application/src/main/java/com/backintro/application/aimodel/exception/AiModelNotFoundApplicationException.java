package com.backintro.application.aimodel.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public class AiModelNotFoundApplicationException extends ApplicationException {
    public AiModelNotFoundApplicationException(AiModelId id) {
        super("AiModel with id " + id.value() + " was not found.");
    }
}
