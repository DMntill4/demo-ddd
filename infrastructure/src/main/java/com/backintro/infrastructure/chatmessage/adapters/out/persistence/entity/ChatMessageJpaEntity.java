package com.backintro.infrastructure.chatmessage.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "chat_messages")
public class ChatMessageJpaEntity {
    @Id
    private UUID id;

    @Column(name = "conversation_id", nullable = false)
    private UUID conversationId;

    @Column(name = "message_type_id", nullable = false)
    private UUID messageTypeId;

    @Column(name = "participant_id", nullable = false)
    private UUID participantId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ChatMessageJpaEntity() {
    }

    public ChatMessageJpaEntity(UUID id, UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata, LocalDateTime createdAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.messageTypeId = messageTypeId;
        this.participantId = participantId;
        this.content = content;
        this.metadata = metadata;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getConversationId() { return conversationId; }
    public void setConversationId(UUID conversationId) { this.conversationId = conversationId; }

    public UUID getMessageTypeId() { return messageTypeId; }
    public void setMessageTypeId(UUID messageTypeId) { this.messageTypeId = messageTypeId; }

    public UUID getParticipantId() { return participantId; }
    public void setParticipantId(UUID participantId) { this.participantId = participantId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
