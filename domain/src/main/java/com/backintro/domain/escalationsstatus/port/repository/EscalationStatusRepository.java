package com.backintro.domain.escalationsstatus.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;

public interface EscalationStatusRepository {
    EscalationStatus save(EscalationStatus aggregate);
    Optional<EscalationStatus> findById(EscalationStatusId id);
    List<EscalationStatus> findAll();
    void delete(EscalationStatus aggregate);
}
