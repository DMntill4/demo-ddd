package com.backintro.infrastructure.encounter.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;

public interface EncounterJpaRepository extends JpaRepository<EncounterJpaEntity, UUID> {
}
