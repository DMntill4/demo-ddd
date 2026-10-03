package com.backintro.domain.conversationsstatus.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.conversationsstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;

public interface ConversationStatusRepository {
    ConversationStatus save(ConversationStatus aggregate);
    Optional<ConversationStatus> findById(ConversationStatusId id);
    List<ConversationStatus> findAll();
    void delete(ConversationStatus aggregate);
}
