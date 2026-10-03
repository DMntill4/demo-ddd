package com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatAiSettingsJpaEntity;

public interface ChatAiSettingsJpaRepository extends JpaRepository<ChatAiSettingsJpaEntity, UUID> {
}
