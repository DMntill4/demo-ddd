package com.backintro.application.priority.usecase;

import com.backintro.application.priority.exception.PriorityNotFoundApplicationException;
import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class DeletePriorityUseCase {
    private final PriorityRepository repository;

    public DeletePriorityUseCase(PriorityRepository repository) {
        this.repository = repository;
    }

    public void execute(PriorityId id) {
        Priority aggregate = repository.findById(id)
                .orElseThrow(() -> new PriorityNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
