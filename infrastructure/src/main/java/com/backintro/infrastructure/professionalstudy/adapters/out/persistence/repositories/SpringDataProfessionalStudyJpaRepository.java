package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyJpaEntity;

public interface SpringDataProfessionalStudyJpaRepository extends JpaRepository<ProfessionalStudyJpaEntity, UUID> {
}
