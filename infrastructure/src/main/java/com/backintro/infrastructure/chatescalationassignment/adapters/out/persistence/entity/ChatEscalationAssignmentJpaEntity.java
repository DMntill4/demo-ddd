package com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "chat_escalation_assignments")
public class ChatEscalationAssignmentJpaEntity {
    @Id
    private UUID id;

    @Column(name = "escalation_id", nullable = false)
    private UUID escalationId;

    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;

    @Column(name = "assigned_at", nullable = false)
    private LocalDateTime assignedAt;

    public ChatEscalationAssignmentJpaEntity() {
    }

    public ChatEscalationAssignmentJpaEntity(UUID id, UUID escalationId, UUID professionalId, LocalDateTime assignedAt) {
        this.id = id;
        this.escalationId = escalationId;
        this.professionalId = professionalId;
        this.assignedAt = assignedAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getEscalationId() { return escalationId; }
    public void setEscalationId(UUID escalationId) { this.escalationId = escalationId; }

    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }

    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt = assignedAt; }
}
