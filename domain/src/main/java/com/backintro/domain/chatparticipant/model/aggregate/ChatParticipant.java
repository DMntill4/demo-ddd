package com.backintro.domain.chatparticipant.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatparticipant.event.ChatParticipantRegisteredEvent;
import com.backintro.domain.chatparticipant.event.ChatParticipantUpdatedEvent;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public class ChatParticipant extends AggregateRoot {
    private final ChatParticipantId id;
    private UUID conversationId;
    private UUID participantTypeId;
    private UUID patientId;
    private UUID professionalId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatParticipant(
            ChatParticipantId id, UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = conversationId;
        this.participantTypeId = participantTypeId;
        this.patientId = patientId;
        this.professionalId = professionalId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ChatParticipant register(UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId) {
        ChatParticipantId id = ChatParticipantId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatParticipant aggregate = new ChatParticipant(id, conversationId, participantTypeId, patientId, professionalId, now, now);
        aggregate.recordEvent(new ChatParticipantRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatParticipant restore(
            ChatParticipantId id, UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ChatParticipant(id, conversationId, participantTypeId, patientId, professionalId, createdAt, updatedAt);
    }

    public void update(UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId) {
        this.conversationId = conversationId;
        this.participantTypeId = participantTypeId;
        this.patientId = patientId;
        this.professionalId = professionalId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatParticipantUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatParticipantId id() { return id; }
    public UUID conversationId() { return conversationId; }
    public UUID participantTypeId() { return participantTypeId; }
    public UUID patientId() { return patientId; }
    public UUID professionalId() { return professionalId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
