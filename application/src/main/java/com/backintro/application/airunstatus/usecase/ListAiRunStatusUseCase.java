package com.backintro.application.airunstatus.usecase;

import java.util.List;
import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

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
