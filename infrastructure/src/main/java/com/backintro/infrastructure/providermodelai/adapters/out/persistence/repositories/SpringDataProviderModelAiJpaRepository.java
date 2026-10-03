package com.backintro.infrastructure.providermodelai.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;

public interface SpringDataProviderModelAiJpaRepository extends JpaRepository<ProviderModelAiJpaEntity, UUID> {
}
