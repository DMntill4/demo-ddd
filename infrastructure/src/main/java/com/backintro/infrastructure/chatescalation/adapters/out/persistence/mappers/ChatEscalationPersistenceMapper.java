package com.backintro.infrastructure.chatescalation.adapters.out.persistence.mappers;

import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationJpaEntity;

public class ChatEscalationPersistenceMapper {
    public ChatEscalationJpaEntity toJpa(ChatEscalation aggregate) {
        if (aggregate == null) return null;
        return new ChatEscalationJpaEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.statusId(), aggregate.fromAi(), aggregate.reason(), aggregate.createdAt());
    }

    public ChatEscalation toDomain(ChatEscalationJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatEscalation.restore(new ChatEscalationId(entityObj.getId()), entityObj.getConversationId(), entityObj.getStatusId(), entityObj.getFromAi(), entityObj.getReason(), entityObj.getCreatedAt());
    }
}
