package com.backintro.domain.airunstatus.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;

public interface AiRunStatusRepository {
    AiRunStatus save(AiRunStatus aggregate);
    Optional<AiRunStatus> findById(AiRunStatusId id);
    List<AiRunStatus> findAll();
    boolean existsByCode(String code);
    void delete(AiRunStatus aggregate);
}
