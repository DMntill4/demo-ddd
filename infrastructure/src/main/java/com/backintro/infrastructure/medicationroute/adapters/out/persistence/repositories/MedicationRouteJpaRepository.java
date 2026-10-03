package com.backintro.infrastructure.medicationroute.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteJpaEntity;

public interface MedicationRouteJpaRepository extends JpaRepository<MedicationRouteJpaEntity, UUID> {
}
