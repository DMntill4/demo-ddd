package com.backintro.application.priority.usecase;

import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.application.priority.exception.PriorityNotFoundApplicationException;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class GetPriorityByIdUseCase {
    private final PriorityRepository repository;

    public GetPriorityByIdUseCase(PriorityRepository repository) {
        this.repository = repository;
    }

    public PriorityResponse execute(PriorityId id) {
        return repository.findById(id)
                .map(PriorityResponse::fromDomain)
                .orElseThrow(() -> new PriorityNotFoundApplicationException(id));
    }
}
