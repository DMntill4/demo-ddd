package com.backintro.application.escalationsstatus.usecase;

import java.util.List;
import com.backintro.application.escalationsstatus.dto.EscalationStatusResponse;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;

public class ListEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public ListEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public List<EscalationStatusResponse> execute() {
        return repository.findAll()
                .stream()
                .map(EscalationStatusResponse::fromDomain)
                .toList();
    }
}
