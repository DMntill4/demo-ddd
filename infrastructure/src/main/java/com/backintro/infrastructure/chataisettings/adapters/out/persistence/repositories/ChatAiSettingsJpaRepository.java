package com.backintro.infrastructure.chataisettings.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.entity.ChatAiSettingsJpaEntity;

public interface ChatAiSettingsJpaRepository extends JpaRepository<ChatAiSettingsJpaEntity, UUID> {
    boolean existsByCode(String code);
}
