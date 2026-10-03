package com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;

public interface SpringDataChatConversationJpaRepository extends JpaRepository<ChatConversationJpaEntity, UUID> {
}
