package com.backintro.domain.chatescalationassignment.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatescalationassignment.event.ChatEscalationAssignmentRegisteredEvent;
import com.backintro.domain.chatescalationassignment.event.ChatEscalationAssignmentUpdatedEvent;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public class ChatEscalationAssignment extends AggregateRoot {
    private final ChatEscalationAssignmentId id;
    private UUID escalationId;
    private UUID professionalId;
    private LocalDateTime assignedAt;

    private ChatEscalationAssignment(
            ChatEscalationAssignmentId id, UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.escalationId = escalationId;
        this.professionalId = professionalId;
        this.assignedAt = assignedAt;
    }

    public static ChatEscalationAssignment register(UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
        ChatEscalationAssignmentId id = ChatEscalationAssignmentId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatEscalationAssignment aggregate = new ChatEscalationAssignment(id, escalationId, professionalId, assignedAt);
        aggregate.recordEvent(new ChatEscalationAssignmentRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatEscalationAssignment restore(
            ChatEscalationAssignmentId id, UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
        return new ChatEscalationAssignment(id, escalationId, professionalId, assignedAt);
    }

    public void update(UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
        this.escalationId = escalationId;
        this.professionalId = professionalId;
        this.assignedAt = assignedAt;
        recordEvent(new ChatEscalationAssignmentUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatEscalationAssignmentId id() { return id; }
    public UUID escalationId() { return escalationId; }
    public UUID professionalId() { return professionalId; }
    public LocalDateTime assignedAt() { return assignedAt; }
}
