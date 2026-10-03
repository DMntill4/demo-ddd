package com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;

public interface ConversationStatusJpaRepository extends JpaRepository<ConversationStatusJpaEntity, UUID> {
}
