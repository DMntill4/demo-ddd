package com.backintro.application.providermodelai.command;

import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public record UpdateProviderModelAiCommand(ProviderModelAiId id, String name, String code) {
}
