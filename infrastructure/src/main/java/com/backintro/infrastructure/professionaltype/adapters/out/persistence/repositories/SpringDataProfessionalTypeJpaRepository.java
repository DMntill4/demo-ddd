package com.backintro.infrastructure.professionaltype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeJpaEntity;

public interface SpringDataProfessionalTypeJpaRepository extends JpaRepository<ProfessionalTypeJpaEntity, UUID> {
}
