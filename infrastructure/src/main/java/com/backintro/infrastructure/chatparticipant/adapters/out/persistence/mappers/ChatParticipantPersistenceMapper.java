package com.backintro.infrastructure.chatparticipant.adapters.out.persistence.mappers;

import com.backintro.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantJpaEntity;

public class ChatParticipantPersistenceMapper {
    public ChatParticipantJpaEntity toJpa(ChatParticipant aggregate) {
        if (aggregate == null) return null;
        return new ChatParticipantJpaEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.participantTypeId(), aggregate.patientId(), aggregate.professionalId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ChatParticipant toDomain(ChatParticipantJpaEntity entityObj) {
        if (entityObj == null) return null;
        return ChatParticipant.restore(new ChatParticipantId(entityObj.getId()), entityObj.getConversationId(), entityObj.getParticipantTypeId(), entityObj.getPatientId(), entityObj.getProfessionalId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
