package com.backintro.infrastructure.risklevel.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelJpaEntity;

public interface SpringDataRiskLevelJpaRepository extends JpaRepository<RiskLevelJpaEntity, UUID> {
}
