package com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantJpaEntity;

public interface SpringDataChatParticipantJpaRepository extends JpaRepository<ChatParticipantJpaEntity, UUID> {
}
