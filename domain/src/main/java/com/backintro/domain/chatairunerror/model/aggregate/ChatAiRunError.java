package com.backintro.domain.chatairunerror.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatairunerror.event.ChatAiRunErrorRegisteredEvent;
import com.backintro.domain.chatairunerror.event.ChatAiRunErrorUpdatedEvent;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public class ChatAiRunError extends AggregateRoot {
    private final ChatAiRunErrorId id;
    private UUID aiRunId;
    private String errorMessage;
    private String errorCode;
    private String providerErrorId;
    private LocalDateTime createdAt;

    private ChatAiRunError(
            ChatAiRunErrorId id, UUID aiRunId, String errorMessage, String errorCode, String providerErrorId, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.aiRunId = aiRunId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        this.createdAt = createdAt;
    }

    public static ChatAiRunError register(UUID aiRunId, String errorMessage, String errorCode, String providerErrorId) {
        ChatAiRunErrorId id = ChatAiRunErrorId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatAiRunError aggregate = new ChatAiRunError(id, aiRunId, errorMessage, errorCode, providerErrorId, now);
        aggregate.recordEvent(new ChatAiRunErrorRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatAiRunError restore(
            ChatAiRunErrorId id, UUID aiRunId, String errorMessage, String errorCode, String providerErrorId, LocalDateTime createdAt) {
        return new ChatAiRunError(id, aiRunId, errorMessage, errorCode, providerErrorId, createdAt);
    }

    public void update(UUID aiRunId, String errorMessage, String errorCode, String providerErrorId) {
        this.aiRunId = aiRunId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        recordEvent(new ChatAiRunErrorUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiRunErrorId id() { return id; }
    public UUID aiRunId() { return aiRunId; }
    public String errorMessage() { return errorMessage; }
    public String errorCode() { return errorCode; }
    public String providerErrorId() { return providerErrorId; }
    public LocalDateTime createdAt() { return createdAt; }
}
