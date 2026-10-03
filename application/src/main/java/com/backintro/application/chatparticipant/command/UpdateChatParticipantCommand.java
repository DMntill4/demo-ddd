package com.backintro.application.chatparticipant.command;

import java.util.UUID;

import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public record UpdateChatParticipantCommand(ChatParticipantId id, UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId) {
}
