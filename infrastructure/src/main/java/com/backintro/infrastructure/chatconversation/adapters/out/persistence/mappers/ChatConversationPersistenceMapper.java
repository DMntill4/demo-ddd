package com.backintro.infrastructure.chatconversation.adapters.out.persistence.mappers;

import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;

public class ChatConversationPersistenceMapper {
    public ChatConversationJpaEntity toJpa(ChatConversation aggregate) {
        if (aggregate == null) return null;
        return new ChatConversationJpaEntity(aggregate.id().value(), aggregate.conversationStatusId(), aggregate.priorityId(), aggregate.lastMessageAt(), aggregate.closed(), aggregate.closedAt(), aggregate.closedBy(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ChatConversation toDomain(ChatConversationJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatConversation.restore(new ChatConversationId(entityObj.getId()), entityObj.getConversationStatusId(), entityObj.getPriorityId(), entityObj.getLastMessageAt(), entityObj.getClosed(), entityObj.getClosedAt(), entityObj.getClosedBy(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
