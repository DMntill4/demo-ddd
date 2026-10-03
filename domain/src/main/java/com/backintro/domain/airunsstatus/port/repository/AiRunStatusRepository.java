package com.backintro.domain.airunsstatus.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;

public interface AiRunStatusRepository {
    AiRunStatus save(AiRunStatus aggregate);
    Optional<AiRunStatus> findById(AiRunStatusId id);
    List<AiRunStatus> findAll();
    void delete(AiRunStatus aggregate);
}
