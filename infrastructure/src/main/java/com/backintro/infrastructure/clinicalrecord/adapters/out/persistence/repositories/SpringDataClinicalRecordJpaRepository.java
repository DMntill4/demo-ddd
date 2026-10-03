package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;

public interface SpringDataClinicalRecordJpaRepository extends JpaRepository<ClinicalRecordJpaEntity, UUID> {
}
