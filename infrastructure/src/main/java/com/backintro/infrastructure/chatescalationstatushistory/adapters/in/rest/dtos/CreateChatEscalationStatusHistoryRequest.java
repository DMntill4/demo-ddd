package com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateChatEscalationStatusHistoryRequest(UUID escalationId, UUID escalationStatusId, LocalDateTime changedAt) {
}
