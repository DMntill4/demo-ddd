package com.backintro.infrastructure.gender.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderJpaEntity;

public interface SpringDataGenderJpaRepository extends JpaRepository<GenderJpaEntity, UUID> {
}
