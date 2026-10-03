package com.backintro.infrastructure.chatescalation.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationJpaEntity;

public interface SpringDataChatEscalationJpaRepository extends JpaRepository<ChatEscalationJpaEntity, UUID> {
}
