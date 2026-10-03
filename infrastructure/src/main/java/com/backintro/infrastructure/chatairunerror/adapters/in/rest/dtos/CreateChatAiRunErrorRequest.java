package com.backintro.infrastructure.chatairunerror.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateChatAiRunErrorRequest(UUID aiRunId, String errorMessage, String errorCode, String providerErrorId) {
}
