package com.backintro.application.priority.usecase;

import java.util.List;
import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class ListPriorityUseCase {
    private final PriorityRepository repository;

    public ListPriorityUseCase(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<PriorityResponse> execute() {
        return repository.findAll()
                .stream()
                .map(PriorityResponse::fromDomain)
                .toList();
    }
}
