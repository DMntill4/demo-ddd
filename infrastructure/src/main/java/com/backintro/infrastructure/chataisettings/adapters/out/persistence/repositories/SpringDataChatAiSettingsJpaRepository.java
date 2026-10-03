package com.backintro.infrastructure.chataisettings.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.entity.ChatAiSettingsJpaEntity;

public interface SpringDataChatAiSettingsJpaRepository extends JpaRepository<ChatAiSettingsJpaEntity, UUID> {
}
