package com.backintro.infrastructure.chatescalationassignment.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatEscalationAssignmentRequest(UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
}
