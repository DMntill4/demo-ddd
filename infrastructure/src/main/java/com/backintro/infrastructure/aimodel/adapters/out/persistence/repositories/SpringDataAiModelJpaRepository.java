package com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.entity.AiModelJpaEntity;

public interface SpringDataAiModelJpaRepository extends JpaRepository<AiModelJpaEntity, UUID> {
}
