package com.backintro.infrastructure.contact.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.entity.ContactJpaEntity;

public interface ContactJpaRepository extends JpaRepository<ContactJpaEntity, UUID> {
}
