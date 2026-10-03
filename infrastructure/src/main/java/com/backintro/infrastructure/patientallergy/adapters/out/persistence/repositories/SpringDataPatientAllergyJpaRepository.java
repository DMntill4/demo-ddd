package com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;

public interface SpringDataPatientAllergyJpaRepository extends JpaRepository<PatientAllergyJpaEntity, UUID> {
}
