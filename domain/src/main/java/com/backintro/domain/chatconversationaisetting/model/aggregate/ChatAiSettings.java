package com.backintro.domain.chatconversationaisetting.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatconversationaisetting.event.ChatAiSettingsRegisteredEvent;
import com.backintro.domain.chatconversationaisetting.event.ChatAiSettingsUpdatedEvent;
import com.backintro.domain.chatconversationaisetting.model.valueobject.ChatAiSettingsId;

public class ChatAiSettings extends AggregateRoot {
    private final ChatAiSettingsId id;
    private UUID conversationId;
    private boolean aiEnabled;
    private UUID defaultModelId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatAiSettings(
            ChatAiSettingsId id, UUID conversationId, boolean aiEnabled, UUID defaultModelId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = conversationId;
        this.aiEnabled = aiEnabled;
        this.defaultModelId = defaultModelId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ChatAiSettings register(UUID conversationId, boolean aiEnabled, UUID defaultModelId) {
        ChatAiSettingsId id = ChatAiSettingsId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatAiSettings aggregate = new ChatAiSettings(id, conversationId, aiEnabled, defaultModelId, now, now);
        aggregate.recordEvent(new ChatAiSettingsRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatAiSettings restore(
            ChatAiSettingsId id, UUID conversationId, boolean aiEnabled, UUID defaultModelId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ChatAiSettings(id, conversationId, aiEnabled, defaultModelId, createdAt, updatedAt);
    }

    public void update(UUID conversationId, boolean aiEnabled, UUID defaultModelId) {
        this.conversationId = conversationId;
        this.aiEnabled = aiEnabled;
        this.defaultModelId = defaultModelId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ChatAiSettingsUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiSettingsId id() { return id; }
    public UUID conversationId() { return conversationId; }
    public boolean aiEnabled() { return aiEnabled; }
    public UUID defaultModelId() { return defaultModelId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
