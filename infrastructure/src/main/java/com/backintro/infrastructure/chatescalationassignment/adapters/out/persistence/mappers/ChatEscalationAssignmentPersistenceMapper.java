package com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.mappers;

import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.entity.ChatEscalationAssignmentJpaEntity;

public class ChatEscalationAssignmentPersistenceMapper {
    public ChatEscalationAssignmentJpaEntity toJpa(ChatEscalationAssignment aggregate) {
        if (aggregate == null) return null;
        return new ChatEscalationAssignmentJpaEntity(aggregate.id().value(), aggregate.escalationId(), aggregate.professionalId(), aggregate.assignedAt());
    }

    public ChatEscalationAssignment toDomain(ChatEscalationAssignmentJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatEscalationAssignment.restore(new ChatEscalationAssignmentId(entityObj.getId()), entityObj.getEscalationId(), entityObj.getProfessionalId(), entityObj.getAssignedAt());
    }
}
