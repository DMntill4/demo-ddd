package com.backintro.application.providermodelai.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public class ProviderModelAiNotFoundApplicationException extends ApplicationException {
    public ProviderModelAiNotFoundApplicationException(ProviderModelAiId id) {
        super("ProviderModelAi with id " + id.value() + " was not found.");
    }
}
