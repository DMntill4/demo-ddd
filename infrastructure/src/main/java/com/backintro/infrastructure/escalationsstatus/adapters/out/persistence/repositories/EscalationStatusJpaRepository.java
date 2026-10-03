package com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;

public interface EscalationStatusJpaRepository extends JpaRepository<EscalationStatusJpaEntity, UUID> {
}
