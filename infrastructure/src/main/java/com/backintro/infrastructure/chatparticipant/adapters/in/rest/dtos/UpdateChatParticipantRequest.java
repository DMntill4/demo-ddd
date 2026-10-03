package com.backintro.infrastructure.chatparticipant.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatParticipantRequest(UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId) {
}
