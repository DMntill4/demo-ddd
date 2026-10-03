package com.backintro.domain.chatairun.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatairun.event.ChatAiRunRegisteredEvent;
import com.backintro.domain.chatairun.event.ChatAiRunUpdatedEvent;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;

public class ChatAiRun extends AggregateRoot {
    private final ChatAiRunId id;
    private UUID conversationId;
    private UUID messageId;
    private UUID modelId;
    private UUID aiRunStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatAiRun(
            ChatAiRunId id, UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = conversationId;
        this.messageId = messageId;
        this.modelId = modelId;
        this.aiRunStatusId = aiRunStatusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ChatAiRun register(UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId) {
        ChatAiRunId id = ChatAiRunId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatAiRun aggregate = new ChatAiRun(id, conversationId, messageId, modelId, aiRunStatusId, now, now);
        aggregate.recordEvent(new ChatAiRunRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatAiRun restore(
            ChatAiRunId id, UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ChatAiRun(id, conversationId, messageId, modelId, aiRunStatusId, createdAt, updatedAt);
    }

    public void update(UUID conversationId, UUID messageId, UUID modelId, UUID aiRunStatusId) {
        this.conversationId = conversationId;
        this.messageId = messageId;
        this.modelId = modelId;
        this.aiRunStatusId = aiRunStatusId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatAiRunUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiRunId id() { return id; }
    public UUID conversationId() { return conversationId; }
    public UUID messageId() { return messageId; }
    public UUID modelId() { return modelId; }
    public UUID aiRunStatusId() { return aiRunStatusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
