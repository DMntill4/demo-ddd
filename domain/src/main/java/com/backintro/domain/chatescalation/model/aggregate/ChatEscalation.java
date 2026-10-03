package com.backintro.domain.chatescalation.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatescalation.event.ChatEscalationRegisteredEvent;
import com.backintro.domain.chatescalation.event.ChatEscalationUpdatedEvent;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public class ChatEscalation extends AggregateRoot {
    private final ChatEscalationId id;
    private UUID conversationId;
    private UUID statusId;
    private boolean fromAi;
    private String reason;
    private LocalDateTime createdAt;

    private ChatEscalation(
            ChatEscalationId id, UUID conversationId, UUID statusId, boolean fromAi, String reason, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = conversationId;
        this.statusId = statusId;
        this.fromAi = fromAi;
        this.reason = reason;
        this.createdAt = createdAt;
    }

    public static ChatEscalation register(UUID conversationId, UUID statusId, boolean fromAi, String reason) {
        ChatEscalationId id = ChatEscalationId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatEscalation aggregate = new ChatEscalation(id, conversationId, statusId, fromAi, reason, now);
        aggregate.recordEvent(new ChatEscalationRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatEscalation restore(
            ChatEscalationId id, UUID conversationId, UUID statusId, boolean fromAi, String reason, LocalDateTime createdAt) {
        return new ChatEscalation(id, conversationId, statusId, fromAi, reason, createdAt);
    }

    public void update(UUID conversationId, UUID statusId, boolean fromAi, String reason) {
        this.conversationId = conversationId;
        this.statusId = statusId;
        this.fromAi = fromAi;
        this.reason = reason;
        recordEvent(new ChatEscalationUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatEscalationId id() { return id; }
    public UUID conversationId() { return conversationId; }
    public UUID statusId() { return statusId; }
    public boolean fromAi() { return fromAi; }
    public String reason() { return reason; }
    public LocalDateTime createdAt() { return createdAt; }
}
