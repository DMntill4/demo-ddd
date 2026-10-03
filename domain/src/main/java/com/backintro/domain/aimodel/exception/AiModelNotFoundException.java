package com.backintro.domain.aimodel.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public class AiModelNotFoundException extends DomainException {
    public AiModelNotFoundException(AiModelId id) {
        super("AiModel with id " + id.value() + " was not found.");
    }
}
