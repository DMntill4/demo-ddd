package com.backintro.infrastructure.chatairunerror.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "chat_ai_run_errors")
public class ChatAiRunErrorJpaEntity {
    @Id
    private UUID id;

    @Column(name = "ai_run_id", nullable = false)
    private UUID aiRunId;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "provider_error_id")
    private String providerErrorId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ChatAiRunErrorJpaEntity() {
    }

    public ChatAiRunErrorJpaEntity(UUID id, UUID aiRunId, String errorMessage, String errorCode, String providerErrorId, LocalDateTime createdAt) {
        this.id = id;
        this.aiRunId = aiRunId;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getAiRunId() { return aiRunId; }
    public void setAiRunId(UUID aiRunId) { this.aiRunId = aiRunId; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    public String getProviderErrorId() { return providerErrorId; }
    public void setProviderErrorId(String providerErrorId) { this.providerErrorId = providerErrorId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
