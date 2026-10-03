package com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactJpaEntity;

public interface SpringDataPhoneContactJpaRepository extends JpaRepository<PhoneContactJpaEntity, UUID> {
}
