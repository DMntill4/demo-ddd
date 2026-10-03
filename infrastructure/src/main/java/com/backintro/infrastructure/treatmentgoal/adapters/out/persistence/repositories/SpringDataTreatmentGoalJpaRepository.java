package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalJpaEntity;

public interface SpringDataTreatmentGoalJpaRepository extends JpaRepository<TreatmentGoalJpaEntity, UUID> {
}
