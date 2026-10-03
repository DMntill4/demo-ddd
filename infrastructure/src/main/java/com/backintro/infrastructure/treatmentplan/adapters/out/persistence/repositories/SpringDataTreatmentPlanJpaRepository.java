package com.backintro.infrastructure.treatmentplan.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.entity.TreatmentPlanJpaEntity;

public interface SpringDataTreatmentPlanJpaRepository extends JpaRepository<TreatmentPlanJpaEntity, UUID> {
}
