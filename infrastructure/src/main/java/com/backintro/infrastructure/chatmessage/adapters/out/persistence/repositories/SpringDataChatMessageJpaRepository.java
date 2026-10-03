package com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageJpaEntity;

public interface SpringDataChatMessageJpaRepository extends JpaRepository<ChatMessageJpaEntity, UUID> {
}
