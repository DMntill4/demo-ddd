package com.backintro.application.escalationstatus.usecase;

import com.backintro.application.escalationstatus.command.UpdateEscalationStatusCommand;
import com.backintro.application.escalationstatus.dto.EscalationStatusResponse;
import com.backintro.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class UpdateEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public UpdateEscalationStatusUseCase(EscalationStatusRepository repository) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(UpdateEscalationStatusCommand command) {
        EscalationStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.code());
        EscalationStatus saved = repository.save(aggregate);
        return EscalationStatusResponse.fromDomain(saved);
    }
}
