package com.backintro.domain.providermodelai.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public class ProviderModelAiNotFoundException extends DomainException {
    public ProviderModelAiNotFoundException(ProviderModelAiId id) {
        super("ProviderModelAi with id " + id.value() + " was not found.");
    }
}
