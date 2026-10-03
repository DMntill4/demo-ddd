package com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;

public interface TreatmentStatusJpaRepository extends JpaRepository<TreatmentStatusJpaEntity, UUID> {
    boolean existsByCode(String code);
}
