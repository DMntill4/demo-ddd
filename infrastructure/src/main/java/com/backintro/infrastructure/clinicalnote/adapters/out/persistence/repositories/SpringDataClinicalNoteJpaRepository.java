package com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteJpaEntity;

public interface SpringDataClinicalNoteJpaRepository extends JpaRepository<ClinicalNoteJpaEntity, UUID> {
}
