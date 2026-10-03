package com.backintro.application.providermodelsai.command;

import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;

public record UpdateProviderModelAiCommand(ProviderModelAiId id, String nameProviderAi, String razonSocial, String sitioWeb) {
}
