package com.backintro.infrastructure.escalationstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.escalationstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;

public interface SpringDataEscalationStatusJpaRepository extends JpaRepository<EscalationStatusJpaEntity, UUID> {
}
