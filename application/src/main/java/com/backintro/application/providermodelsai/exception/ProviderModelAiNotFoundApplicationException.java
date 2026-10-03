package com.backintro.application.providermodelsai.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;

public class ProviderModelAiNotFoundApplicationException extends ApplicationException {
    public ProviderModelAiNotFoundApplicationException(ProviderModelAiId id) {
        super("ProviderModelAi with id " + id.value() + " was not found.");
    }
}
