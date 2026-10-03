package com.backintro.application.escalationsstatus.usecase;

import com.backintro.application.escalationsstatus.dto.EscalationStatusResponse;
import com.backintro.application.escalationsstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;

public class GetEscalationStatusByIdUseCase {
    private final EscalationStatusRepository repository;

    public GetEscalationStatusByIdUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(EscalationStatusId id) {
        return repository.findById(id)
                .map(EscalationStatusResponse::fromDomain)
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(id));
    }
}
