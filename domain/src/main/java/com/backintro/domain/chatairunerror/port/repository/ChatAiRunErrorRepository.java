package com.backintro.domain.chatairunerror.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public interface ChatAiRunErrorRepository {
    ChatAiRunError save(ChatAiRunError aggregate);
    Optional<ChatAiRunError> findById(ChatAiRunErrorId id);
    List<ChatAiRunError> findAll();
    void delete(ChatAiRunError aggregate);
}
