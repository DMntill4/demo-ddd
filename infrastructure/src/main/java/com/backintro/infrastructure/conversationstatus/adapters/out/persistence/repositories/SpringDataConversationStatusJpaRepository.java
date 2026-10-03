package com.backintro.infrastructure.conversationstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.conversationstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;

public interface SpringDataConversationStatusJpaRepository extends JpaRepository<ConversationStatusJpaEntity, UUID> {
}
