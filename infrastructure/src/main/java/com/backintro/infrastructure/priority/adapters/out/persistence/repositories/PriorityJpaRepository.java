package com.backintro.infrastructure.priority.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;

public interface PriorityJpaRepository extends JpaRepository<PriorityJpaEntity, UUID> {
}
