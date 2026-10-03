package com.backintro.infrastructure.sendertype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeJpaEntity;

public interface SpringDataSenderTypeJpaRepository extends JpaRepository<SenderTypeJpaEntity, UUID> {
}
