package com.backintro.infrastructure.encounterstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.encounterstatus.adapters.out.persistence.entity.EncounterStatusJpaEntity;

public interface SpringDataEncounterStatusJpaRepository extends JpaRepository<EncounterStatusJpaEntity, UUID> {
}
