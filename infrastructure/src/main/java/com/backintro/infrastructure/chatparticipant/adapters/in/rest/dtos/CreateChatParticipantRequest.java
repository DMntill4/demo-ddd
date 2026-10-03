package com.backintro.infrastructure.chatparticipant.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateChatParticipantRequest(UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId) {
}
