package com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers;

import com.backintro.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity.ChatEscalationStatusHistoryJpaEntity;

public class ChatEscalationStatusHistoryPersistenceMapper {
    public ChatEscalationStatusHistoryJpaEntity toJpa(ChatEscalationStatusHistory aggregate) {
        if (aggregate == null) return null;
        return new ChatEscalationStatusHistoryJpaEntity(aggregate.id().value(), aggregate.escalationId(), aggregate.escalationStatusId(), aggregate.createdAt(), aggregate.changedAt());
    }

    public ChatEscalationStatusHistory toDomain(ChatEscalationStatusHistoryJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatEscalationStatusHistory.restore(new ChatEscalationStatusHistoryId(entityObj.getId()), entityObj.getEscalationId(), entityObj.getEscalationStatusId(), entityObj.getCreatedAt(), entityObj.getChangedAt());
    }
}
