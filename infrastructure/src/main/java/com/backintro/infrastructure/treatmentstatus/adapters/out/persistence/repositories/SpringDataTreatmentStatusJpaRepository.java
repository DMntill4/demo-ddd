package com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;

public interface SpringDataTreatmentStatusJpaRepository extends JpaRepository<TreatmentStatusJpaEntity, UUID> {
}
