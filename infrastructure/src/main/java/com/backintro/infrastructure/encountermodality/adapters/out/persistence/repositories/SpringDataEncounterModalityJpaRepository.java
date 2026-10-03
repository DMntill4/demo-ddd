package com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityJpaEntity;

public interface SpringDataEncounterModalityJpaRepository extends JpaRepository<EncounterModalityJpaEntity, UUID> {
}
