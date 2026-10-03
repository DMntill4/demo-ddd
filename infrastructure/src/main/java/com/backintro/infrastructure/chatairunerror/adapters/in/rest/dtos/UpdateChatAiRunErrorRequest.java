package com.backintro.infrastructure.chatairunerror.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatAiRunErrorRequest(UUID aiRunId, String errorMessage, String errorCode, String providerErrorId) {
}
