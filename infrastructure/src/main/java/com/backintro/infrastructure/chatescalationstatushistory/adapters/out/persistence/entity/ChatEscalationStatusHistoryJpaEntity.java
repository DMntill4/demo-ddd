package com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "chat_escalation_status_history")
public class ChatEscalationStatusHistoryJpaEntity {
    @Id
    private UUID id;

    @Column(name = "escalation_id", nullable = false)
    private UUID escalationId;

    @Column(name = "escalation_status_id", nullable = false)
    private UUID escalationStatusId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    public ChatEscalationStatusHistoryJpaEntity() {
    }

    public ChatEscalationStatusHistoryJpaEntity(UUID id, UUID escalationId, UUID escalationStatusId, LocalDateTime createdAt, LocalDateTime changedAt) {
        this.id = id;
        this.escalationId = escalationId;
        this.escalationStatusId = escalationStatusId;
        this.createdAt = createdAt;
        this.changedAt = changedAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getEscalationId() { return escalationId; }
    public void setEscalationId(UUID escalationId) { this.escalationId = escalationId; }

    public UUID getEscalationStatusId() { return escalationStatusId; }
    public void setEscalationStatusId(UUID escalationStatusId) { this.escalationStatusId = escalationStatusId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
}
