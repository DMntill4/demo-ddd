package com.backintro.infrastructure.study.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.study.adapters.out.persistence.entity.StudyJpaEntity;

public interface StudyJpaRepository extends JpaRepository<StudyJpaEntity, UUID> {
}
