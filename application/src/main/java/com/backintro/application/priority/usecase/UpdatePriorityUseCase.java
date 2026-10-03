package com.backintro.application.priority.usecase;

import com.backintro.application.priority.command.UpdatePriorityCommand;
import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.application.priority.exception.PriorityNotFoundApplicationException;
import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class UpdatePriorityUseCase {
    private final PriorityRepository repository;

    public UpdatePriorityUseCase(PriorityRepository repository) {
        this.repository = repository;
    }

    public PriorityResponse execute(UpdatePriorityCommand command) {
        Priority aggregate = repository.findById(command.id())
                .orElseThrow(() -> new PriorityNotFoundApplicationException(command.id()));
        aggregate.update(command.namePriority());
        Priority saved = repository.save(aggregate);
        return PriorityResponse.fromDomain(saved);
    }
}
