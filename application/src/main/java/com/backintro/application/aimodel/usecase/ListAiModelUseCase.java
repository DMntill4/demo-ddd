package com.backintro.application.aimodel.usecase;

import java.util.List;
import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;

public class ListAiModelUseCase {
    private final AiModelRepository repository;

    public ListAiModelUseCase(AiModelRepository repository) {
        this.repository = repository;
    }

    public List<AiModelResponse> execute() {
        return repository.findAll()
                .stream()
                .map(AiModelResponse::fromDomain)
                .toList();
    }
}
