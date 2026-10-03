package com.backintro.application.airunsstatus.usecase;

import java.util.List;
import com.backintro.application.airunsstatus.dto.AiRunStatusResponse;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;

public class ListAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public ListAiRunStatusUseCase(AiRunStatusRepository repository) {
        this.repository = repository;
    }

    public List<AiRunStatusResponse> execute() {
        return repository.findAll()
                .stream()
                .map(AiRunStatusResponse::fromDomain)
                .toList();
    }
}
