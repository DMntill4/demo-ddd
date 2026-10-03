package com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatEscalationStatusHistoryRequest(UUID escalationId, UUID escalationStatusId, LocalDateTime changedAt) {
}
