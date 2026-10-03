package com.backintro.application.priority.usecase;

import com.backintro.application.priority.command.RegisterPriorityCommand;
import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class RegisterPriorityUseCase {
    private final PriorityRepository repository;

    public RegisterPriorityUseCase(PriorityRepository repository) {
        this.repository = repository;
    }

    public PriorityResponse execute(RegisterPriorityCommand command) {
        Priority aggregate = Priority.register(command.namePriority());
        Priority saved = repository.save(aggregate);
        return PriorityResponse.fromDomain(saved);
    }
}
