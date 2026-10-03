package com.backintro.application.chatescalationstatushistory.command;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

public record UpdateChatEscalationStatusHistoryCommand(ChatEscalationStatusHistoryId id, UUID escalationId, UUID escalationStatusId, LocalDateTime changedAt) {
}
