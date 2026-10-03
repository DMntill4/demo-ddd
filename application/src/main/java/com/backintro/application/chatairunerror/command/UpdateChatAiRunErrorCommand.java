package com.backintro.application.chatairunerror.command;

import java.util.UUID;

import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public record UpdateChatAiRunErrorCommand(ChatAiRunErrorId id, UUID aiRunId, String errorMessage, String errorCode, String providerErrorId) {
}
