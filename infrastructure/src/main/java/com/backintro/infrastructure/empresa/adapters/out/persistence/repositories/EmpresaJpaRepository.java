package com.backintro.infrastructure.empresa.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaJpaEntity;

public interface EmpresaJpaRepository extends JpaRepository<EmpresaJpaEntity, UUID> {
}
