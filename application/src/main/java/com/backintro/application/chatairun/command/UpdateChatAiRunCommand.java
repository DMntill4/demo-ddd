package com.backintro.application.chatairun.command;

import java.util.UUID;

import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public record UpdateChatAiRunCommand(ChatAiRunId id, UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId) {
}
