package com.backintro.infrastructure.airunstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.airunstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;

public interface AiRunStatusJpaRepository extends JpaRepository<AiRunStatusJpaEntity, UUID> {
    boolean existsByCode(String code);
}
