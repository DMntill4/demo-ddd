package com.backintro.infrastructure.chatairun.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunJpaEntity;

public interface SpringDataChatAiRunJpaRepository extends JpaRepository<ChatAiRunJpaEntity, UUID> {
}
